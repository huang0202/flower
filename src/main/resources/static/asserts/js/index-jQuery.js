$(function () {

    //鼠标滚动导航的固定与消失

    var navOffset = $("header").offset().top;
    $(window).scroll(function () {
        var scrollPos = $(window).scrollTop();
        if (scrollPos > navOffset) {
            $("header").addClass("fixed");
        } else {
            $("header").removeClass("fixed");
        }
    });

    var navOffset1 = $(".head").offset().top;
    $(window).scroll(function () {
        var scrollPos = $(window).scrollTop();
        if (scrollPos > navOffset) {
            $(".head").addClass("fixed");
        } else {
            $(".head").removeClass("fixed");
        }
    });


    //侧导航
    $(".iconfont1").click(function () {
        $('.main-nav').toggleClass('active');
        $(".aside").toggleClass('active');
    });






    var startRolltwo = setInterval(rolltwo, 2000);
    $(".hualist-ul").hover(function () {
        clearInterval(startRolltwo);
    }, function () {
        startRolltwo = setInterval(rolltwo, 2000);
    });


    //花语  鼠标移入遮罩消失
    let imgs = $('.xqa');
    console.log(imgs)
    imgs.each(function (index, element) {
        $(this).mouseenter(function () {
            $('.zhezhao').eq(index).css({display: 'block'}).animate({right: 0, top: 0})
        })
    });

    imgs.each(function (index, element) {
        $(this).mouseleave(function () {
            $('.zhezhao').eq(index).animate({right: '-100%', top: '-100%'});
        })
    });

});