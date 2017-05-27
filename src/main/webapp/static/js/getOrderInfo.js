/**
 * Created by shiyu on 2017/5/26.
 */
/*
 * 订单结算页
 * 2017-05-26
 * */
//接口地址
var url = '';
var succCode = 200;
var orderNumber = '';
$(function () {
    orderNumber = '0526-0969-0005';
    var ids = new Array();
    ids = window.location.search.split('=')[1];
    init(ids);
    $('.orderAddress').empty();
    $('.orderPhone').empty();
    $('.orderUser').empty();
    //收货地址
    $('#addressBtn').click(function (e) {
        var orderUser = $('#addressee').val();
        var orderPhone = $('#phone').val();
        var orderAddress = $('#address').val();
        // alert(orderUser+' '+orderPhone+' '+orderAddress);
        $('.orderAddress').empty().append(orderAddress);
        $('.orderPhone').empty().append(orderPhone);
        $('.orderUser').empty().append(orderUser);
        $.ajax({
            type: "post",
            url: url + '/order/perfected',
            xhrFields: {
                withCredentials: true //支持附带详细信息
            },
            data: {
                orderNumber: orderNumber,
                address: orderAddress,
                addressee: orderUser,
                phone: orderPhone
            },
            success: function (data) {
                if (data.code == succCode) {
                    $('#err-prompt').empty().append(data.message + ' ' + data.data);
                    orderNumber = data.data;
                }
                else {
                    $('#err-prompt').empty().append('查询失败--/order/perfected');
                }
            },
            error: function () {
                console.log('接口错误');
                $('#err-prompt').empty().append('接口错误---订单结算页加载页面--/order/perfected');
            }
        });
        e.preventDefault();
    });

    $('#orderBtn').click(function (e) {
        var html = '<p class="success-text">提交订单成功</p>';
        var _this = $(this);

        $.ajax({
            type: "post",
            url: url + '/order/payment',
            xhrFields: {
                withCredentials: true //支持附带详细信息
            },
            data: {
                orderNumber: orderNumber,
            },
            success: function (data) {
                if (data.code == succCode) {
                    $('#err-prompt').empty().append(data.message + ' ' + data.data);
                    orderNumber = data.data;
                    timer1 = setTimeout(function () {
                        $(_this).removeClass('success_tip');
                        clearTimeout(timer1);
                        $('body').append(html);
                        $('.success-text').animate({
                            'top': '50px',
                            'opacity': '1'
                        }, 700, function () {
                            $('.success-text').fadeOut(800, function () {
                                $(_this).addClass('success_tip');
                                $('.success-text').remove();
                            });
                        });
                    }, 500);
                    setTimeout(function () {
                        window.location.href = 'order.html';
                    }, 600);
                }
                else {
                    $('#err-prompt').empty().append('查询失败--/order/payment');
                }
            },
            error: function () {
                console.log('接口错误');
                $('#err-prompt').empty().append('接口错误---订单结算页加载页面--/order/payment');
            }
        });

        e.preventDefault();
    });

});
function init(ids) {
    $.ajax({
        type: "post",
        url: url + '/order/create',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            cartIdList: ids
        },
        success: function (data) {
            var page = '';
            if (data.code == succCode) {
                orderNumber = data.data;
                $('#err-prompt').empty().append(orderNumber);
                $('.orderNumber').empty().append(orderNumber);
                // for(var i=0;i<data.data.list.length;i++){
                //     page += '<div class="goods-item clear">'
                //         +'<div class="p-img fl">'
                //         +'<a href="#"><img src="../../static/img/bird1.jpg" alt=""></a>'
                //         +'</div>'
                //         +'<div class="p-name fl">'
                //         +'<p><a href="#">飞鸟 肥鸟 4X 全网通版 2GB+16GB 香槟金 移动联通电信4G手机</a></p>'
                //         +'<p><span>颜色：</span><span>金</span><span>尺寸：</span><span>2GB 16GB</span></p>'
                //         +'<p><a href="#" class="seven a-type" title="七天退换"></a><span class="seven-span">支持7天无理由退货</span></p>'
                //         +'</div>'
                //         +'<div class="p-price fl">'
                //         +'<span class="red-price p-price-price">￥<span>999.00</span></span>'
                //         +'<span class="p-price-num">x<span>1</span></span>'
                //         +'<span class="p-price-text">有货</span>'
                //         +'</div>'
                //         +'</div>';
                // }
                // $('#goodsList').empty().append(page);
            }
            else {
                $('#err-prompt').empty().append('查询失败--/order/create');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---订单结算页加载页面--/order/create');
        }
    });
}