/*
 * 公共头部js  监听是否登录
 * 2017-05-15
 * */
//接口地址
var url = '';
var succCode = 200;

$(function () {

    $.ajax({
        type: "post",
        url: url + "/user/checkLogin",
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {
            if (data.code == 1) {
                $('.nav-a').addClass('undis');
                $('.user-a').removeClass('undis');
                $('#head-username').empty().append(data.message);
                getUserImg(data.message);
                // var imgUrl = getUserImg(data.message);
                // if (imgUrl == '' || imgUrl == undefined) {
                //     $('#head-username').siblings('img').attr('src', '../../static/img/bird.jpg');
                // } else {
                //     $('#head-username').siblings('img').attr('src', url + imgUrl);
                // }

            }
            else {
                $('.nav-a').removeClass('undis');
                $('.user-a').addClass('undis');

                $('#err').removeClass('undis');
                $('#err').empty().append(data.message + '---/user/checkLogin');
            }
        },
        error: function () {
            $('#err').removeClass('undis');
            $('#err').empty().append('接口错误--/user/checkLogin');
        }
    });
    //退出
    $('#logout').click(function (e) {

        logout();
        e.preventDefault();
    });

    $('.main-page').click(function (e) {
        jumpPage('/main.html');
        e.preventDefault();
    });

    $('.login-page').click(function (e) {
        jumpPage('/login.html');
        e.preventDefault();
    });
    $('.register-page').click(function (e) {
        jumpPage('/register.html');
        e.preventDefault();
    });
    $('.user-page').click(function (e) {
        jumpPage('/user.html');
        e.preventDefault();
    });
    $('.cart-page').click(function (e) {
        jumpPage('/cart.html');
        e.preventDefault();
    });
    $('.order-page').click(function (e) {
        jumpPage('/order.html');
        e.preventDefault();
    });
    //评价
    $('.evaluate-page').click(function (e) {
        jumpPage('/evaluate.html');
        e.preventDefault();
    });
});

function logout() {
    $.ajax({
        type: "get",
        url: url + "/user/logout",
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {

            jumpPage('/main.html');

            $('#err').removeClass('undis');
            $('#err').empty().append(data.message + '--/user/logout');
        },
        error: function () {
            $('#err').removeClass('undis');
            $('#err').empty().append('接口错误--/user/logout');
        }
    });
}

//跳转页面
function jumpPage(page) {
    window.location.href = url + page;
}

//访问个人信息接口
function getUserImg(user) {
    // var portrait = '';
    $.ajax({
        type: "get",
        url: url + '/user',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {
            if (data.code == succCode) {
                if (data.data.username == user) {
                    if (data.data.portrait)
                        $('#head-username').siblings('img').attr('src', data.data.portrait);
                    else $('#head-username').siblings('img').attr('src', '../../static/img/bird.jpg');
                }
            }
            else {
                $('#err-prompt').empty().append('获取信息失败 ');
                $('body').empty().append(data);
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---加载页面');
        }
    });
    // return portrait;
}