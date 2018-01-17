var testEditor;

<!--超过字数截取-->
$(function () {
    var text = document.getElementById("note_content1").innerHTML;
    if (text.length > 110) {
        document.getElementById("note_content1").innerHTML = text.substring(0, 110) + "...";

    }
    var text = document.getElementById("note_content2").innerHTML;
    if (text.length > 110) {
        document.getElementById("note_content2").innerHTML = text.substring(0, 110) + "...";
    }
    var text = document.getElementById("note_content3").innerHTML;
    if (text.length > 110) {
        document.getElementById("note_content3").innerHTML = text.substring(0, 110) + "...";
    }
    var text = document.getElementById("note_content4").innerHTML;
    if (text.length > 110) {
        document.getElementById("note_content4").innerHTML = text.substring(0, 110) + "...";
    }

    var text = document.getElementById("note_content5").innerHTML;
    if (text.length > 110) {
        document.getElementById("note_content5").innerHTML = text.substring(0, 110) + "...";
    }
});
<!--返回头部-->
$(".totop").click(function () {
    $("html,body").animate({scrollTop: 0});
})
$("#flex-item1").on("click", function () {
    $(".content").css("display", "block");
    $(".md").css("display", "none");
    $(".back").css("display", "none");
    $("body").css("background-color","#ffffff");
})
$("#flex-item3").on("click", function () {
    $(".content").css("display", "none");
    $(".md").css("display", "none");
    $(".back").css("display", "block");
    $("body").css("background-color","#fafafa");
})
/*处理md*/
var numb = 1;
$(function mdToHtml() {
    for (var i = 0; i < 5; i++) {
        var id = "note_content" + numb;
        //获取要显示的内容
        numb = numb + 1;
        numb = numb % 6;
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
