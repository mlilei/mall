package com.sy.mall.pojo;

import javax.persistence.Id;

/**
 * Created by 李磊
 * on 17-4-29.
 */
public class UserRole {
    @Id
    private Long userId;
    @Id
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
