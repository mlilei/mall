/*
 * 商品详情页
 * 2017-05-17
 * */
//接口地址
var url = '';
var succCode = 200;

$(function () {


    var id = window.location.search.split('=')[1];
    $.ajax({
        type: "get",
        url: url + '/wares/getWares/' + id,
        xhrFields: {
            withCredentials: true //支持附带详细信息
        },
        success: function (data) {
            if (data.code == succCode) {
                $('#err-prompt').empty().append(data.message);
                $('.waresType').empty().append(data.data.waresType);
                $('.waresName').empty().append(data.data.waresName);
                $('.imageUrl').attr('src', data.data.imageUrl);
                $('.waresPrice').empty().append(data.data.price);
                var memory = data.data.memory.split('/');
                var memoryPage = '';
                memoryPage += '<a href="javascript:;" class="value active"><span>' + memory[0] + '</span></a>';
                for (var i = 1; i < memory.length; i++) {
                    memoryPage += '<a href="javascript:;" class="value"><span>' + memory[i] + '</span></a>';
                }
                $('.waresMemory').empty().append(memoryPage);
                var color = data.data.color.split('/');
                var colorPage = '';
                colorPage += ' <a href="javascript:;" class="value active"><span>' + color[0] + '</span></a>';
                for (var i = 1; i < color.length; i++) {
                    colorPage += ' <a href="javascript:;" class="value"><span>' + color[i] + '</span></a>';
                }
                $('.waresColor').empty().append(colorPage);
                $('.waresDetail').empty().append(data.data.detail);

                var parameter = data.data.parameter;
                var type = '';
                var page = '';
                for (var i = 0; i < parameter.length;) {
                    type = parameter[i].parameterType;
                    page += '<div class="Ptable-item">'
                        + ' <h3>' + type + '</h3>'
                        + '<dl>';
                    for (; i < parameter.length; i++) {
                        if (parameter[i].parameterType !== type) {
                            break;
                        }
                        page += '<dt>' + parameter[i].parameterName + '</dt>';
                        page += '<dd>' + parameter[i].parameterValue + '</dd>';
                    }
                    page += ' </dl>'
                        + ' </div>';
                }
                $('#specifications').empty().append(page);
                click();
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

    //商品介绍  tab切换
    $(".tabDemo li").click(function (e) {
        $(this).addClass("active").siblings().removeClass("active");
        var tabDemoNum = $(".tabDemo li").index(this);
        $(".tabDemoCon>div").eq(tabDemoNum).removeClass("undis").siblings().addClass("undis");
        e.preventDefault();
    });

    /*
     * 成功提示
     * Author:zmj
     * Date:2017-4-21
     */
    var timer1 = '';
    $('.addCart').click(function (e) {

        var memoryValue = $('.waresMemory .active span').html();
        var colorValue = $('.waresColor .active span').html();
        $.ajax({
            type: "post",
            url: url + '/cart/addWares',
            xhrFields: {
                withCredentials: true //支持附带详细信息
            },
            data: {
                cartId: id,
                color: colorValue,
                memory: memoryValue
            },
            success: function (data) {
                if (data.code == succCode) {
                    var html = '<p class="success-text">加入购物车成功</p>';
                    var _this = $(this);
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
                }
                else {
                    $('#err-prompt').empty().append('查询失败--/cart/addWares');
                }
            },
            error: function () {
                console.log('接口错误');
                $('#err-prompt').empty().append('接口错误--/cart/addWares');
            }
        });
        e.preventDefault();
    });
});
function click() {
    //规格颜色点击样式
    $('.specifications a').click(function (e) {
        $(this).addClass('active').siblings().removeClass('active');
        e.preventDefault();
    });
}