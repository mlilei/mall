/*
 * 商品详情页
 * 2017-05-17
 * */
//接口地址
var url = '';
//var succCode = 1;

$(function () {
    //规格颜色点击样式
    $('.specifications a').click(function (e) {
        $(this).addClass('active').siblings().removeClass('active');
        e.preventDefault();
    })

    //商品介绍  tab切换
    $(".tabDemo li").click(function (e) {
        $(this).addClass("active").siblings().removeClass("active");
        var tabDemoNum = $(".tabDemo li").index(this);
        $(".tabDemoCon>div").eq(tabDemoNum).removeClass("undis").siblings().addClass("undis");
        e.preventDefault();
    })
    // +'<div class="tabDemoCon">'
    // +'<div class="">'
    // +'<iframe src="waresIntroduction.html" width="100%" height="600" scrolling="no" frameborder="0" name="waresIntro" id="waresIntro" onload="iFrameHeight('+"waresIntro"+')"></iframe>'
    // +'</div>'
    // +'<div class="undis more-cont">'
    // +'<iframe src="specifications.html" width="100%" height="600" scrolling="no" frameborder="0" name="spec" id="spec" onload="iFrameHeight('+"spec"+')"></iframe>'
    // +'</div>'
    // +'<div class="undis">'
    // +'<iframe src="customerService.html" width="100%" height="600" frameborder="0" name="custSer" id="custSer" onload="iFrameHeight('+"custSer"+')"></iframe>'
    // +'</div>'
    // +'</div>'
});
