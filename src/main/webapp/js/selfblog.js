/**
 * Created by macbookair on 2018/1/11.
 */
$(function () {
    $(".shouye_btn").on("click",function () {
        $(".right_shouye").css("display","block");
        $(".right_fenlei").css("display","none");
        $(".right_guanli").css("display","none")
    })
    $(".fenlei_btn").on("click",function () {
        $(".right_shouye").css("display","none");
        $(".right_fenlei").css("display","block");
        $(".right_guanli").css("display","none")
    })
    $(".guanli_btn").on("click",function () {
        $(".right_shouye").css("display","none");
        $(".right_fenlei").css("display","none");
        $(".right_guanli").css("display","block")
    });
    $("#deleteArticle").on("click", function () {
        var aid = $("#readytodeleteid").val();
        var json = {
            aid: aid,
        }
        $.ajax({
            url: "/cl/deleteArticle",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(json),
            success: function (res) {
                console.log()
                if (res.code == 1) {
                    alert("删除成功");
                }
                else {
                    alert("删除失败");
                }
            }
        })
    });
});

