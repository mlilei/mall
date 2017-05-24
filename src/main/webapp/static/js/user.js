/*
 * 个人中心页
 * 2017-05-16
 * */

//接口地址
var url = '';
var succCode = 200;

$(function () {
    $.ajax({
        type: "get",
        url: url + '/user',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message + '--/user');
                if (data.data.portrait == '') {
                    $('#portrait').attr('src', '../../static/img/bird.jpg');
                }
                else {
                    $('#portrait').attr('src', url + data.data.portrait);
                }
                $('#username').empty().append(data.data.nickname);
                $('#nickname').empty().append(data.data.username);
                var birthday = data.data.birthday.split(" ", 1);
                $('#birthday').empty().append(birthday);
                $('#phone').empty().append(data.data.phone);
                $('#email').empty().append(data.data.email);
                $('#introduction').empty().append(data.data.introduction);

                if (data.data.gender == 'MALE') {
                    $('#gender').empty().append('男');
                }
                else if (data.data.gender == 'FEMALE') {
                    $('#gender').empty().append('女');
                }
                else {
                    $('#gender').empty().append('保密');
                }
            }
            else {
                $('#err-prompt').empty().append('获取信息失败 --/user');
                $('body').empty().append(data);
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---加载页面--/user');
        }
    });
});