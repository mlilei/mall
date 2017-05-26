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

$(function () {
    //收货地址
    $('#addressBtn').click(function (e) {
        var orderUser = $('#addressee').val();
        var orderPhone = $('#phone').val();
        var orderAddress = $('#address').val();
        // alert(orderUser+' '+orderPhone+' '+orderAddress);
        $('.orderAddress').empty().append(orderAddress);
        $('.orderPhone').empty().append(orderPhone);
        $('.orderUser').empty().append(orderUser);
        e.preventDefault();
    });

});