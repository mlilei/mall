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
    //商品详情---规格颜色点击样式
    $('.specifications a').click(function (e) {
        $(this).addClass('active').siblings().removeClass('active');
        e.preventDefault();
    })

    //商品详情---商品介绍  tab切换
    $(".tabDemo li").click(function (e) {
        $(this).addClass("active").siblings().removeClass("active");
        var tabDemoNum = $(".tabDemo li").index(this);
        $(".tabDemoCon>div").eq(tabDemoNum).removeClass("undis").siblings().addClass("undis");
        e.preventDefault();
    })
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
    $.ajax({
        type: "get",
        url: url + '/wares/getWares/' + id,
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message);

            }
            else {
                $('#err-prompt').empty().append('查询失败--/wares/getWares/{id}');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---详情页加载页面--/wares/getWares/{id}');
        }
    });
    var page = '<div class="container-fluid wares-detail">'
        + '<ol class="breadcrumb">'
        + '<li><a href="#">首页</a></li>'
        + '<li><a href="#">飞鸟手机</a></li>'
        + '<li class="active">bird1</li>'
        + '</ol>'
        + '<div class="cont-wares row">'
        + '<div class="col-md-5 wares-img">'
        + '<img src="../../static/img/bg3.jpg"/>'
        + '<div class="img-child">'
        + '<ul class="clear">'
        + '<li><a href="javascript:;"><img src="../../static/img/bird2.jpg"/></a></li>'
        + '<li><a href="javascript:;"><img src="../../static/img/bird3.jpg"/></a></li>'
        + '<li><a href="javascript:;"><img src="../../static/img/bird.jpg"/></a></li>'
        + '<li><a href="javascript:;"><img src="../../static/img/bg3.jpg"/></a></li>'
        + '</ul>'
        + '</div>'
        + '</div>'
        + '<div class="col-md-7 wares-parameter">'
        + '<h2 id="wares-name">高通旗舰处理器飞鸟 Bird 1 超长续航</h2>'
        + '<ul class="parameter-type margintop">'
        + '<li><span class="type-tit">价格：</span><span class="type-price" id="price">￥2999.00</span></li>'
        + '<li><span class="type-tit">领券：</span><span class="full-cut">满200减10</span><span class="full-cut">满500减20</span></li>'
        + '<li><span class="type-tit">积分：</span><span class="">本次消费可获得3599积分</span></li>'
        + '</ul>'
        + '<div class="customer-service margintop">'
        + '<span class="key">客服：</span>'
        + '<span class="value"><a href="javascript:;"><i class="glyphicon glyphicon-comment"></i>联系客服</a></span>'
        + '</div>'
        + '<div class="specifications margintop">'
        + '<span class="key">选择版本：</span><span class="cpu">骁龙821 性能版，最高主频 2.35GHz，Adreno 530 图形处理器</span><br/>'
        + '<a href="#" class="value active"><span>标准版 4GB内存+64GB&nbsp;&nbsp;<span class="price">2799元</span></span></a>'
        + '<a href="#" class="value"><span>高配版 6GB内存+128GB&nbsp;<span class="price">3299元</span></span></a>'
        + '<a href="#" class="value"><span>全球版 6GB内存+128GB&nbsp;<span class="price">3499元</span></span></a>'
        + '</div>'
        + '<div class="color margintop specifications">'
        + ' <span class="key">选择颜色：</span><br/>'
        + ' <a href="#" class="value active"><span>亮银黑</span></a>'
        + '<a href="#" class="value"><span>冰川银</span></a>'
        + '<a href="#" class="value"><span>亮黑色</span></a>'
        + '</div>'
        + '<div class="add-cart margintop">'
        + '<div class="btn btn-danger">加入购物车</div>'
        + '</div>'
        + '<div class="prompt">'
        + '<i class="glyphicon glyphicon-ok-circle"></i>'
        + '<span>支持7天无理由退货</span>'
        + '</div>'
        + '</div>'
        + '</div>'
        + '<div class="cont-detail clear">'
        + '<ul class="detail-tit clear fl tabDemo">'
        + '<li class="active"><a href="#">商品介绍</a></li>'
        + '<li class="more-tit"><a href="#">规格与包装</a></li>'
        + '<li><a href="#">售后保障</a></li>'
        + '</ul>'
        + '<div class="btn btn-default fr">加入购物车</div>'
        + '</div>'
        + '</div>';

    $('#waresIndex').empty().append(page);
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