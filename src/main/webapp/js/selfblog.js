/**
 * Created by macbookair on 2018/1/11.
 */
var numb = 1;
$(function mdToHtml() {
    for (var i = 0; i < 3; i++) {
        var id = "mdView" + numb;
        //获取要显示的内容
        numb = numb + 1;
        numb = numb % 4;
        console.log(id);
        //var content = $("#article_content").text();
        editormd.markdownToHTML(id, {
            htmlDecode: "style,script,iframe",
            emoji: true,
            taskList: true,
            tex: true, // 默认不解析
            flowChart: true, // 默认不解析
            sequenceDiagram: true, // 默认不解析
        });
    }
});

$(function () {
    var numb = 1;
    for (var i = 0; i < 3; i++) {
        var id = "mdView" + numb
        numb++
        numb = numb % 4
        var text = document.getElementById(id).innerHTML;
        if (text.length > 400) {
            document.getElementById(id).innerHTML = text.substring(0, 400) + "...";
        }
    }
});
$(".totop").click(function () {
    $("html,body").animate({scrollTop: 0});
})
$(function () {
    $(".shouye_btn").on("click", function () {
        $(".right_shouye").css("display", "block");
        // $(".right_fenlei").css("display", "none");
        $(".right_guanli").css("display", "none");
        $(".right_team").css("display","none");

    })
    // $(".fenlei_btn").on("click", function () {
    //     $(".right_shouye").css("display", "none");
    //     $(".right_fenlei").css("display", "block");
    //     $(".right_guanli").css("display", "none");
    //     $(".right_team").css("display","none");
    //
    // })
    $(".guanli_btn").on("click", function () {
        $(".right_shouye").css("display", "none");
        // $(".right_fenlei").css("display", "none");
        $(".right_guanli").css("display", "block");
        $(".right_team").css("display","none");
    })
    $(".team_btn").on("click",function () {
        $(".right_shouye").css("display","none");
        // $(".right_fenlei").css("display","none");
        $(".right_guanli").css("display","none");
        $(".right_team").css("display","block");
    })
})
$('#checkpassword').bind('input propertychange', function()
{
    var pwd=$("#inputpassword").val();
    var rpwd=$("#checkpassword").val();
    if (rpwd!=pwd){
        $("#error").html("两次输入密码不同");
        $("#changeself").attr('disabled',true);
        $("#changeself").css("color","gray");
    }else {
        $("#error").html("");
        $("#changeself").attr('disabled',false);
        $("#changeself").css("color","#337ab7");
    }
})
$('#inputpassword').bind('input propertychange', function()
{
    var pwd=$("#inputpassword").val();
    var rpwd=$("#checkpassword").val();
    if (rpwd!=pwd){
        $("#error").html("两次输入密码不同");
        $("#changeself").attr('disabled',true);
        $("#changeself").css("color","gray");
    }else {
        $("#error").html("");
        $("#changeself").attr('disabled',false);
        $("#changeself").css("color","#337ab7");
    }
})
$("#changeself").on("click", function () {
    var uid =$("#uid").val();
    var nickname = $("#nickname").val();
    var originpassword=$("#originpassword").val();
    var inputpassword=$("#inputpassword").val();
    var json = {
        uid:uid,
        nickname: nickname,
        originpassword: originpassword,
        inputpassword: inputpassword
    }
    $.ajax({
        url: "/cl/changeSelf",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(json),
        success: function (res) {
            if (res.code == 1) {
                alert("修改成功");
                window.location.reload();
            }
            else if(res.code==-1){
                alert("原密码错误请重新输入");
            }else {
                alert("修改成功，请重新登录");
                window.location="/cl/login";
            }
        }
    })
})


