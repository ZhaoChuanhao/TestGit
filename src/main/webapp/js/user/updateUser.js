$(function () {
    //获取原用户名
    var userName = $("#userName").val();

    $("#bt").click(function () {

        if($("#userName").val() == ""){
            $("span").text("");
            $("#userName").next().text("*用户名不能为空！");
        }else if($("#password").val() == ""){
            $("span").text("");
            $("#password").next().text("*原密码不能为空！");
        }else if($("#password2").val() == ""){
            $("span").text("");
            $("#password2").next().text("*新密码不能为空！");
        }else if($("#password3").val() == ""){
            $("span").text("");
            $("#password3").next().text("*确认密码不能为空！");
        }else if($("#password2").val() != $("#password3").val()){
            $("span").text("");
            $("#password3").next().text("新密码与确认密码不一致！");
        }else if(!(/^1[34578]\d{9}$/.test($("#phoneNumber").val()))){
            $("span").text("");
            $("#phoneNumber").next().text("电话格式不正确！");
        }else {
            $.ajax({
                type : "POST",
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                url : path + "/user/checkUser",
                data : {
                    newUserName : $("#userName").val(),
                    userName : userName,
                    password : $("#hiddenPassword").val()
                },
                success : function(data) {
                    data = $.parseJSON(data);
                    if(data == 2){
                        //对新密码进行加密
                        var password2 = hex_md5($("#password2").val());
                        $("#hiddenPassword2").val(password2);
                        $("#updateForm").submit();
                    }else if (data == 1){
                        $("span").text("");
                        $("#password").next().text("*原密码不正确！");
                    }else {
                        if($("#userName").val() == userName){
                            //对新密码进行加密
                            var password2 = hex_md5($("#password2").val());
                            $("#hiddenPassword2").val(password2);
                            $("#updateForm").submit();
                        }else {
                            $("span").text("");
                            $("#userName").next().text("*用户名已存在！");
                        }
                    }
                }
            });

        }
    });

    $("#cancer").click(function () {
        $(location).attr("href", path + "/user/userIndex");
    });

});