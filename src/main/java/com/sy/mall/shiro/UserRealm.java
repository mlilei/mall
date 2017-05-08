package com.sy.mall.shiro;

import com.google.common.collect.Sets;
import com.sy.mall.common.enums.UserStatusEnum;
import com.sy.mall.common.util.BCrypt;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.mapper.PermissionMapper;
import com.sy.mall.mapper.RoleMapper;
import com.sy.mall.mapper.UserMapper;
import com.sy.mall.pojo.Permission;
import com.sy.mall.pojo.Role;
import com.sy.mall.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by 李磊
 * on 2017/5/1.
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[\\w-\\.]+@([\\w-]+\\.)+[a-z]{2,3}");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^1([34578])[0-9]\\d{8}$");
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        Long userId = user.getUserId();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //查询用户角色
        Set<Role> roleSet = roleMapper.listByUserId(userId);
        Set<String> roles = Sets.newHashSet();
        for (Role role : roleSet) {
            roles.add(role.getRoleName());
        }

        //查询角色权限
        Set<Permission> permissionSet = permissionMapper.listByRoleList(new ArrayList<>(roleSet));
        Set<String> permissions = Sets.newHashSet();
        for (Permission permission : permissionSet) {
            permissions.add(permission.getUrl());
        }

        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        LOGGER.info("用户:{},角色:{},权限:{}", user.getUsername(), JsonUtil.toJson(roles), JsonUtil.toJson(permissions));
        return authorizationInfo;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = String.valueOf(authenticationToken.getPrincipal());
        String credentials = new String((char[]) authenticationToken.getCredentials());
        User user = new User();

        //匹配登录方式
        if (EMAIL_PATTERN.matcher(principal).matches()) {
            user.setEmail(principal);
        } else if (PHONE_PATTERN.matcher(principal).matches()) {
            user.setPhone(principal);
        } else {
            user.setUsername(principal);
        }

        //查询用户信息
        List<User> userList = userMapper.select(user);

        //用户不存在
        if (CollectionUtils.isEmpty(userList)) {
            throw new UnknownAccountException("用户不存在,请注册");
        }
        user = userList.get(0);

        //密码错误
        if (!BCrypt.checkpw(credentials, user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确,请重试");
        }

        //账号锁定
        if (UserStatusEnum.DISABLE.equals(user.getStatus())) {
            throw new LockedAccountException("账号已被禁用,请联系管理员");
        }

        return new SimpleAuthenticationInfo(user, credentials, getName());
    }
}
