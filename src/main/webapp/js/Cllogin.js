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
    var json = {
        username: username,
        password: password
    }
    $.ajax({
        url: "/cl/doRegist",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(json),
        success: function (res) {
            console.log(res)
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

    $("#login_header").innerHTML = "hi,来注册:";
    $(".login").css("display", "none");
    $(".regist").css("display", "block");
})
$("#return").on("click", function () {
    $("#login_header").innerHTML = "嗨,请登录:";
    $(".login").css("display", "block");
    $(".regist").css("display", "none");
})