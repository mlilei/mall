/*
 * 购物车页
 * 2017-05-18
 * */
//接口地址
var url = '';
var succCode = 200;

var selects = document.getElementsByName("select");
var selectsLength = selects.length;
$(function () {
    // numOperation();
    $.ajax({
        type: "get",
        url: url + '/cart',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            pageNum: 1,
            pageSize: 5
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
                    for (var i = 0; i < lists.length; i++) {
                        page += '<tr class="cart-wares">'
                            + '<td class="th-input">'
                            + '<input type="checkbox" name="select" value="" onclick="cx()"/>'
                            + '</td>'
                            + '<td class="clear th-tit">'
                            + '<div class="wares-img fl">'
                            + '<img src="' + lists[i].imageUrl + '"/>'
                            + '</div>'
                            + '<div class="wares-tit fl">'
                            + '<div class="p-name">'
                            + '<a href="#">' + lists[i].waresName + '</a>'
                            + ' </div>'
                            + '</div>'
                            + '</td>'
                            + '<td class="th-type">'
                            + '<div class="type-color">颜色：' + lists[i].color + '</div>'
                            + '<div class="type-size">内存：' + lists[i].memory + '</div>'
                            + '</td>'
                            + '<td class="c-price"><span>¥</span><strong>' + lists[i].price + '</strong></td>'
                            + '<td>'
                            + ' <div class="c-amount">'
                            + ' <a href="#" class="nominus reduce" onclick="deleteOneCart(' + lists[i].id + ')">-</a><input type="text" class="text" value="' + lists[i].waresNum + '"/>'
                            + ' <a href="#" class="plus" onclick="addOneCart(' + lists[i].id + ')">+</a>'
                            + ' </div>'
                            + '</td>'
                            + '<td class="c-total"><span>¥</span><strong class="wares-price">' + lists[i].waresPrice + '</strong></td>'
                            + '<td class="type-del">'
                            + '<a href="#" data-toggle="modal" data-target="#delModal" onclick="deleteCart(' + lists[i].id + ')">删除</a>'
                            + '</td>'
                            + ' </tr>';
                    }
                    $('#cartValue').empty().append(page);
                    numOperation();
                }
            }
            else {
                $('#err-prompt').empty().append('查询失败--/cart');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误---购物车页加载页面--/cart');
        }
    });

});
//加减删除操作
function numOperation() {
    selects = document.getElementsByName("select");
    selectsLength = selects.length;
    $('.text').each(function () {
        var num = parseInt($(this).val()),
            a = $(this).parents('tr').find('.c-price strong').html(),
            price = parseFloat($(this).parents('.cart-wares').find('.c-price strong').html()),
            $total = $(this).parents('.cart-wares').find('.c-total strong');
        // 设置减号的样式
        if (num == 1) {
            $(this).parent().find('.reduce').addClass('nominus');
            $(this).parent().find('.reduce').removeClass('minus');
        } else if (num > 1) {
            $(this).parent().find('.reduce').addClass('minus');
            $(this).parent().find('.reduce').removeClass('nominus');
            // $(this).parent().find('.nominus').attr('class', 'minus');
        }
        // 计算总值
        $total.html((price * num).toFixed(2));
    });
    /*
     * 点击加减商品时的效果
     */
    //减
    $('.reduce').click(function (e) {
        var num = parseInt($(this).next('input').val()),
            $num = $(this).next('input'),
            price = parseFloat($(this).parents('tr').find('.c-price strong').html()),
            $total = $(this).parents('tr').find('.c-total strong');
        if (num == 2) {
            // $(this).attr('class', 'nominus');
            $(this).addClass('nominus');
            $(this).removeClass('minus');
        }
        if (num > 1) {
            num--;
        } else num = 1;
        $num.val(num);
        $total.html((price * num).toFixed(2));

        e.preventDefault();
    });
    //加
    $('.plus').click(function (e) {
        var num = parseInt($(this).prev('input').val()),
            $num = $(this).prev('input'),
            price = parseFloat($(this).parents('tr').find('.c-price strong').html()),
            $total = $(this).parents('tr').find('.c-total strong');
        if (num == 1) {
            // $(this).parent().find('.nominus').attr('class', 'minus');
            $(this).parent().find('.reduce').addClass('minus');
            $(this).parent().find('.reduce').removeClass('nominus');
        }
        num++;
        $num.val(num);
        $total.html((price * num).toFixed(2));
        e.preventDefault();
    });
    /*
     * 文本框中直接输入值
     */
    $('.text').keyup(function (e) {
        var num = $(this).val(),
            price = parseFloat($(this).parents('tr').find('.c-price strong').html()),
            $total = $(this).parents('tr').find('.c-total strong');

        // 如果不为数字时强制转换或者为0时强制转换
        if (num == '' || /\D+/.test(num) || num == 0) {
            num = 1;
            $(this).val(num);
            return false;
        }

        // 设置减号的样式
        if (num == 1) {
            $(this).parent().find('.reduce').addClass('nominus');
            $(this).parent().find('.reduce').removeClass('minus');
        } else if (num > 1) {
            $(this).parent().find('.reduce').addClass('minus');
            $(this).parent().find('.reduce').removeClass('nominus');
            // $(this).parent().find('.nominus').attr('class', 'minus');
        }

        // 计算总值
        $total.html((price * num).toFixed(2));

    });
    //监听CheckBox变化，选中加深
    $('input').change(function () {
        if ($('#all-up').is(':checked')) {
            $('.cart-wares').addClass('active');
        } else {
            //判断当前是不是全选按钮
            if (!$(this).val()) {
                if ($(this).is(':checked')) {
                    $(this).parents('.cart-wares').addClass('active');
                } else {
                    $(this).parents('.cart-wares').removeClass('active');
                }
            } else {
                $('.cart-wares').removeClass('active');
            }
        }

        //判断当前选中几件商品
        var selects = document.getElementsByClassName("cart-wares");
        var l = selects.length;
        var num = 0, price = 0.0;
        for (var i = 0; i < l; i++) {
            if ($(selects[i]).is('.active')) {
                ++num;
                price += parseFloat($(selects[i]).children('.c-total').text().slice(1));
            }
        }
        $('#warse-num').html(num);
        $('#total').html(price.toFixed(2));
    });


}

function addOneCart(id) {
    $.ajax({
        type: "post",
        url: url + '/cart/addOne',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            cartId: id
        },
        success: function (data) {
            data;
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message);
            }
            else {
                $('#err-prompt').empty().append('查询失败--/cart/addOne');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误--/cart/addOne');
        }
    });
}

function deleteOneCart(id) {
    $.ajax({
        type: "post",
        url: url + '/cart/removeOne',
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        data: {
            cartId: id
        },
        success: function (data) {
            data;
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message);
            }
            else {
                $('#err-prompt').empty().append('查询失败--/cart/removeOne');
            }
        },
        error: function () {
            console.log('接口错误');
            $('#err-prompt').empty().append('接口错误--/cart/removeOne');
        }
    });
}
//删除
function deleteCart(id) {
    //删除
    $('#del').click(function (e) {
        $(this).parents('tr').addClass('undis');
        // alert(id);
        $.ajax({
            type: "post",
            url: url + '/cart/removeWares',
            xhrFields: {
                withCredentials: true //支持附带详细信息
            },
            data: {
                cartId: id
            },
            success: function (data) {
                data;
                if (data.code == succCode) {
                    $('#err-prompt').empty().append(data.message);
                }
                else {
                    $('#err-prompt').empty().append('查询失败--/cart/removeWares');
                }
            },
            error: function () {
                console.log('接口错误');
                $('#err-prompt').empty().append('接口错误--/cart/removeWares');
            }
        });
        e.preventDefault();
    });
}

//全选
// var selects = document.getElementsByName("select");
// var selectsLength = selects.length;
//上面的全选
function qx() {
    for (var i = 0; i < selectsLength - 1; i++) {
        if (selects[0].checked) {
            selects[i + 1].checked = true;
        } else {
            selects[i + 1].checked = false;
        }
    }
}
//下面的全选
function fqx() {
    for (var i = 0; i < selectsLength - 1; i++) {
        if (selects[selectsLength - 1].checked) {
            selects[i].checked = true;
        } else {
            selects[i].checked = false;
        }
    }
}
//每一个单个的选择
function cx() {
    for (var i = 0; i < selectsLength; i++) {
        if (selects[0].checked) {
            for (var i = 0; i < l; i++) {
                if (selects[i].checked == false) {
                    selects[0].checked = false;
                    selects[selectsLength - 1].checked = false;
                }
            }
        } else {
            if (selects[i].checked == true && selects[i + 1].checked == true) {
                selects[0].checked = true;
                selects[selectsLength - 1].checked = true;
            }
        }
    }
}