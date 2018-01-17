/**
 * 登录AJAX
 */
$("#doLogin").on("click", function () {
    var username = $("#username").val();
    var password = $("#inputpassword").val();
    var json = {
        username: username,
        password: password
    }
    $.ajax({
        url: "/cl/doLogin",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(json),
        success: function (res) {
            console.log()
            if (res.code == 1) {
                alert("登录成功");
                window.location = "/cl/firstpage";
            }
            else {
                alert("用户名或密码错误");
            }
        }
    })
});
$("#doRegist").on("click", function () {
    var username = $("#registusername").val();
    var password = $("#registpassword").val();
    var nickname =$("#nickname").val();
    var academy =$("#academy").val();
    var json = {
        username: username,
        nickname: nickname,
        password: password,
        academy: academy
    }
    $.ajax({
        url: "/cl/doRegist",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(json),
        success: function (res) {
            console.log(res);
            if (res.code == 1) {
                alert("注册成功");
                window.location = "/cl/login";
            }
            else {
                alert("用户名已存在");
            }
        }
    })
});
$("#regist").on("click", function () {

    $(".login_header").html("hi,来注册:");
    $(".login").css("display", "none");
    $(".regist").css("display", "block");
    $(".login_box").height(480);
    $(".login_box").css("top","150px");
});
$("#return").on("click", function () {
    $(".login_header").html("嗨，请登录");
    $(".login").css("display", "block");
    $(".regist").css("display", "none");
    $(".login_box").height(380);
});