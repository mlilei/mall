/*
 * 我的订单页
 * 2017-05-19
 * */

//接口地址
var url = '';
var succCode = 200;

$(function () {
    //筛选条件
    $('#select-btn span').click(function (e) {
        $(this).addClass('undis').siblings().removeClass('undis');
        $('#select-more').is('.undis') ? $('#select-more').removeClass('undis') : $('#select-more').addClass('undis');
        e.preventDefault();
    });
    //所有类名为sleect-id的孩子li 点击事件
    $('.sleect-id li').click(function (e) {
        $(this).addClass('active').siblings().removeClass('active');
        e.preventDefault();
    });

    //所有订单  tab切换
    $(".tabDemo li").click(function (e) {
        $(this).addClass("active").siblings().removeClass("active");
        var tabDemoNum = $(".tabDemo li").index(this);
        $(".tabDemoCon>div").eq(tabDemoNum).removeClass("undis").siblings().addClass("undis");
        e.preventDefault();
    });

    // $('.all-order #succPage').removeClass('undis').empty().append(succPage());
    init();

    $('.pending-payment').empty().append(errPage('待付款'));
    $('.shipment-pending').empty().append(errPage('待发货'));
    $('.goods-to-be-received').empty().append(errPage('待收货'));
    $('.pending-evaluation').empty().append(errPage('待评价'));


	
	
});

function init() {
    $.ajax({
        type: "get",
        url: url + '/order',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            pageNum: 1,
            pageSize: 35
        },
        success: function (data) {
            var page = '';
            var lists = data.data.list;
            if (data.code == succCode) {
                if (lists.length == 0) {
                    page = '<div class="err-page">'
                        + '<div class="right-img fl">'
                        + '<img src="../../static/img/404.jpg"/>'
                        + '</div>'
                        + '</div>';
                    $('#cartValue').empty().append(page);
                }
                else {
                    page += '<div class="order-table table-responsive">'
                        + '<table class="table">'
                        + '<thead>'
                        + '<tr>'
                        + '<th class="text-center">宝贝</th>'
                        + '<th class="text-center">单价</th>'
                        + '<th class="text-center">数量</th>'
                        + '<th class="text-center">商品操作</th>'
                        + '<th class="text-center">实付款</th>'
                        + '<th class="text-center">交易状态</th>'
                        + '<th class="text-center">交易操作</th>'
                        + '</tr>'
                        + '</thead>';
                    for (var i = 0; i < lists.length; i++) {
                        page += '<tr class="sep-row"><td colspan="7"></td></tr>'
                            + '<tbody class="order-list">'
                            + '<tr class="tr-th">'
                            + '<td colspan="1">'
                            + '<span class="gap"></span>'
                            + '<span class="dealtime">' + lists[i].createTime + '</span>'
                            + '<span class="number">订单号：<a href="#">' + lists[i].orderNum + '</a></span>'
                            + '</td>'
                            + '<td colspan="2" class="img-wares">'
                            + '<span>'
                            + '<img src="../../static/img/bird.jpg"/>'
                            + '<a href="#">飞鸟商城</a>'
                            + '</span>'
                            + '</td>'
                            + '<td colspan="1">'
                            + '</td>'
                            + '<td colspan="3" class="text-right del-order">'
                            + '<a href="#" data-toggle="modal" data-target="#delModal" onclick="delOrder(' + lists[i].orderNum + ')"><i class="glyphicon glyphicon-trash"></i></a>'
                            + '</td>'
                            + '</tr>';
                        page += '<tr class="tr-bd">'
                            + '<td class="bd-img-tit clear">'
                            + '<div class="img fl">'
                            + '<img src="' + lists[i].waresList[0].imageUrl + '" />'
                            + '</div>'
                            + '<div class="tit fl">'
                            + '<p><a href="#">' + lists[i].waresList[0].waresName + '</a></p>'
                            + '<p><span>颜色：</span><span>金</span>  <span>内存：</span><span>2GB 16GB</span></p>'
                            + '<p>'
                            + '<a href="#" class="seven a-type" title="七天退换"></a>'
                            + '<a href="#" class="describe a-type" title="如实描述"></a>'
                            + '<a href="#" class="quality a-type" title="正品保证"></a>'
                            + '</p>'
                            + '</div>'
                            + '</td>'
                            + '<td>'
                            + '	<p><span>￥</span><span>' + lists[i].waresList[0].price + '</span></p>'
                            + '</td>'
                            + '<td>'
                            + '<span>' + lists[i].waresList[0].waresNum + '</span>'
                            + '</td>'
                            + '<td class="customer-service">'
                            + '<span><a href="#">申请售后</a></span>'
                            + '</td>'
                            + '<td>'
                            + '<p><span>￥</span><span>2299.00</span></p>'
                            + '<p class="grey-price">（含运费：￥<span>0.00</span>）</p>'
                            + '</td>'
                            + '<td>'
                            + '<span>交易成功</span>'
                            + '</td>'
                            + '<td>'
                            + '<button class="btn btn-default evaluate-page">评价</button>'
                            + '</td>'
                            + '</tr>';
                        for (var j = 1; j < lists[i].waresList.length; j++) {
                            page += '<tr class="tr-bd">'
                                + '<td class="bd-img-tit clear">'
                                + '<div class="img fl">'
                                + '<img src="' + lists[i].waresList[j].imageUrl + '" />'
                                + '</div>'
                                + '<div class="tit fl">'
                                + '<p><a href="#">' + lists[i].waresList[j].waresName + '</a></p>'
                                + '<p><span>颜色：</span><span>金</span>  <span>内存：</span><span>2GB 16GB</span></p>'
                                + '<p>'
                                + '<a href="#" class="seven a-type" title="七天退换"></a>'
                                + '<a href="#" class="describe a-type" title="如实描述"></a>'
                                + '<a href="#" class="quality a-type" title="正品保证"></a>'
                                + '</p>'
                                + '</div>'
                                + '</td>'
                                + '<td>'
                                + '	<p><span>￥</span><span>' + lists[i].waresList[j].price + '</span></p>'
                                + '</td>'
                                + '<td>'
                                + '<span>' + lists[i].waresList[j].waresNum + '</span>'
                                + '</td>'
                                + '<td class="customer-service">'
                                + '<span><a href="#">申请售后</a></span>'
                                + '</td>'
                                + '<td>'
                                + '</td>'
                                + '<td>'
                                + '</td>'
                                + '<td>'
                                + '</td>'
                                + '</tr>';
                        }
                    }
                    page += '</tbody>'
                        + '</table>'
                        + '</div>';
                    $('.all-order #succPage').removeClass('undis').empty().append(page);
                }
            }
            else {
                $('#err-prompt').empty().append('查询失败--/order');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---订单页加载页面--/order');
        }
    });
}

function delOrder(id) {
    //删除订单
    $('#del').click(function (e) {
        alert(id);
        $.ajax({
            type: "post",
            url: url + '/order/delete',
            xhrFields: {
                withCredentials: true //支持附带详细信息
            },
            data: {
                orderNumber: id,
            },
            success: function (data) {
                if (data.code == succCode) {
                    $('#err-prompt').empty().append(data.message + ' ' + data.data);
                    orderNumber = data.data;
                    init();
                    $(this).parents('.order-list').addClass('undis');
                }
                else {
                    $('#err-prompt').empty().append('查询失败--/order/delete');
                }
            },
            error: function () {
                console.log('接口错误');
                $('#err-prompt').empty().append('接口错误---订单结算页加载页面--/order/delete');
            }
        });
        e.preventDefault();
    });

}

//<!--404页面-->
function errPage(text) {
    var page = '<div class="err-page clear">'
        + '<div class="left-text fl">'
        + '<h4>没有<span>' + text + '</span>的订单哦~</h4>'
        + '<button class="btn btn-default"><a href="order.html">查看全部订单</a></button>'
        + '<button class="btn btn-danger"><a href="main.html">去首页看看</a></button>'
        + '</div>'
        + '<div class="right-img fl">'
        + '<img src="../../static/img/bird1.jpg"/>'
        + '</div>'
        + '</div>';
    return page;
}

//<!--有数据的页面-->
function succPage() {
    var page = '<div class="order-table table-responsive">'
        + '<table class="table">'
        + '<thead>'
        + '<tr>'
        + '<th class="text-center">宝贝</th>'
        + '<th class="text-center">单价</th>'
        + '<th class="text-center">数量</th>'
        + '<th class="text-center">商品操作</th>'
        + '<th class="text-center">实付款</th>'
        + '<th class="text-center">交易状态</th>'
        + '<th class="text-center">交易操作</th>'
        + '</tr>'
        + '</thead>'
        + '<tr class="sep-row"><td colspan="7"></td></tr>'
        + '<tbody class="order-list">'
        + '<tr class="tr-th">'
        + '<td colspan="1">'
        + '<span class="gap"></span>'
        + '<span class="dealtime">2017-05-08 13:54:31</span>'
        + '<span class="number">订单号：<a href="#">53862676454</a></span>'
        + '</td>'
        + '<td colspan="2" class="img-wares">'
        + '<span>'
        + '<img src="../../static/img/bird.jpg"/>'
        + '<a href="#">飞鸟商城</a>'
        + '</span>'
        + '</td>'
        + '<td colspan="1">'

        + '</td>'
        + '<td colspan="3" class="text-right del-order">'
        + '<a href="#" data-toggle="modal" data-target="#delModal"><i class="glyphicon glyphicon-trash"></i></a>'
        + '</td>'
        + '</tr>'
        + '<tr class="tr-bd">'
        + '<td class="bd-img-tit clear">'
        + '<div class="img fl">'
        + '<img src="../../static/img/bird2.jpg" />'
        + '</div>'
        + '<div class="tit fl">'
        + '<p><a href="#">飞鸟 肥鸟 4X 全网通版 2GB+16GB 香槟金 移动联通电信4G手机</a></p>'
        + '<p><span>颜色：</span><span>金</span><span>尺寸：</span><span>2GB 16GB</span></p>'
        + '<p>'
        + '<a href="#" class="seven a-type" title="七天退换"></a>'
        + '<a href="#" class="describe a-type" title="如实描述"></a>'
        + '<a href="#" class="quality a-type" title="正品保证"></a>'
        + '</p>'
        + '</div>'
        + '</td>'
        + '<td>'
        + '	<p><span>￥</span><span>2299.00</span></p>'
        + '</td>'
        + '<td>'
        + '<span>1</span>'
        + '</td>'
        + '<td class="customer-service">'
        + '<span><a href="#">申请售后</a></span>'
        + '</td>'
        + '<td>'
        + '<p><span>￥</span><span>2299.00</span></p>'
        + '<p class="grey-price">（含运费：￥<span>0.00</span>）</p>'
        + '</td>'
        + '<td>'
        + '<span>交易成功</span>'
        + '</td>'
        + '<td>'
        + '<button class="btn btn-default evaluate-page">评价</button>'
        + '</td>'
        + '</tr>'
        + '</tbody>'
        + '</table>'
        + '</div>';

    return page;
}
