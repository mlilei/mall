/*
 * 主页
 * 2017-05-20
 * */
//接口地址
var url = '';
var succCode = 200;

$(function () {
    //分类点击事件
    $('#content-nav li').click(function (e) {
        $(this).addClass('active').siblings().removeClass('active');
        // $('#waresDetail').addClass('undis');
        // $('#waresIndex').removeClass('undis');
        if ($(this).is('#phone-wares')) {
            getJson(1, '手机');
        }
        if ($(this).is('#ipad-wares')) {
            getJson(1, '平板');
        }
        if ($(this).is('#notebook-wares')) {
            getJson(1, '笔记本');
        }
        if ($(this).is('#parts-wares')) {
            getJson(1, '配件');
        }
        e.preventDefault();
    });
    //默认查询所有
    getJson(0, 0);
    $('#all-wares').click(function (e) {
        getJson(0, 0);
        e.preventDefault();
    });
    //根据关键字搜索
    $('#search-btn').click(function (e) {
        var value = $('input[type=text]').val();
        getJson(2, value);
        e.preventDefault();
    });

});
function getJson(typeKey, typeValue) {
    var waresTypeValue = '', waresNameValue = '';
    //查询所有
    if (typeKey == 0) {
        waresTypeValue = '';
        waresNameValue = '';
    }
    //根据类型查询
    else if (typeKey == 1) {
        waresTypeValue = typeValue;
        waresNameValue = '';
    }
    //根据名字查询
    else if (typeKey == 2) {
        waresTypeValue = '';
        waresNameValue = typeValue;
    }
    $.ajax({
        type: "post",
        url: url + '/wares/queryWares',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            waresName: waresNameValue,
            waresType: waresTypeValue
        },
        success: function (data) {
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message + '----/wares/queryWares');
                var length = data.data.length;
                var page = '';
                if (length == 0) {
                    page = '<div class="err-page">'
                        + '<div class="right-img fl">'
                        + '<img src="../../static/img/404.jpg"/>'
                        + '</div>'
                        + '</div>';
                    $('#main-index').empty().append(page);
                }
                else {
                    for (var i = 0; i < length; i++) {
                        page += '<li class="brick-item brick-item-m" onclick="gotoDetail(' + data.data[i].waresId + ')">'
                            + '<div class="figure figure-img">'
                            + '<a href="javascript:;">'
                            + '<img src="' + data.data[i].imageUrl + '" alt="' + data.data[i].waresName + '"/>'
                            + '</a>'
                            + '</div>'
                            + '<h3 class="title">'
                            + '<a href="javascript:;"> ' + data.data[i].waresName + ' </a>'
                            + '</h3>'
                            + '<p class="price"><span>' + data.data[i].price + '</span>元</p>'
                            + '<p class="rank">' + data.data[i].commentNumber + '人评价</p>'
                            + '<div class="flag flag-saleoff">享6折</div>' + '<div class="flag flag-new">新品</div>'
                            + '</li>';
                    }
                    $('#main-index').empty().append(page);
                    fnBox($('.brick-item'), 'mouseover');
                }

            }
            else {
                $('#err-prompt').empty().append('查询失败--/wares/queryWares');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---加载页面--/wares/queryWares');
        }
    });
}

//去详情页
function gotoDetail(id) {
    window.location.href = "waresDetail.html?id=" + id;
};


// //iframe 自动适应高度
// function iFrameHeight(id) {
//     var ifm = document.getElementById(id);
//     var subWeb = document.frames ? document.frames[id].document : ifm.contentDocument;
//     if (ifm != null && subWeb != null) {
//         ifm.height = subWeb.body.scrollHeight;
//     }
// };
// 鼠标滑过显示  内容卡片
// fnBox($('.brick-item'), 'mouseover');

function fnBox(oNav, sEvent) {
    oNav.each(function (index) {
        $(this).on(sEvent, function () {
            oNav.removeClass('brick-item-active');
            $(this).addClass('brick-item-active');
        });
        $(this).on('mouseout', function () {
            $(this).removeClass('brick-item-active');

        });
    });
}