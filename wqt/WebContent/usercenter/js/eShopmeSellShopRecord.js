$(function () {
    $(".content .content_lf div h4").each(function () {
        var _this = $(this).attr("data-item");
        if (_this == "true") {
            $(this).next().show();
            $(this).find("i").attr("class", "active");
        }
        $(this).on("click", function () {
            $(this).next().toggle();
            if ($(this).next().is(":hidden")) {
                $(this).attr("data-item", "false");
                $(this).find("i").attr("class", "item");
            } else {
                $(this).attr("data-item", "true");
                $(this).find("i").attr("class", "active");
            }
        })
    })
})