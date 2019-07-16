// 页面加载时左侧状态栏保持上次点击的样子

$(function() {
    $(".content .content_lf div h4").each(function(index, val) {
        if (!pageItems[index]) {
            $(this).next().show();
            $(this).find("i").attr("class", "active");
        }
        $(this).on("click", function() {
            $(this).next().toggle();
            if ($(this).next().is(":hidden")) {
                pageItems[index] = true;
                $(this).find("i").attr("class", "item");
            } else {
                pageItems[index] = false;
                $(this).find("i").attr("class", "active");
            }
        })
    })
})

// 出售店铺单选按钮
$(".prove input[type='radio']").each(function() {
    $(this).on("change", function() {
        $(".prove input[type='radio']").each(function() {
            if ($(this).is(":checked")) {
                $(this).next().css("backgroundPositionX", "-110px")
            } else {
                $(this).next().css("backgroundPositionX", "-88px")
            }
        })
    })
})

// 出售店铺多选框
$(".prove input[type='checkbox']").each(function() {
    $(this).on("change", function() {
        if ($(this).is(":checked")) {
            $(this).next().css("backgroundPositionX", "-22px")
        } else {
            $(this).next().css("backgroundPositionX", "0")
        }
    })
})

// 出售店铺我同意 
$(".sellshop .row .btn input[type='checkbox']").on("change", function() {
    if ($(this).is(":checked")) {
        $(this).next().css("backgroundPositionY", "0")
    } else {
        $(this).next().css("backgroundPositionY", "-14px")
    }
})