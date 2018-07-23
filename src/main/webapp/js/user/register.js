$(function () {
    $("#bt").click(function () {
        if($("#userName").val() == ""){
            $("span").text("");
            $("#userName").next().text("*用户名不能为空！");
        }else if($("#password").val() == ""){
            $("span").text("");
            $("#password").next().text("*密码不能为空！");
        }else if($("#password2").val() == ""){
            $("span").text("");
            $("#password2").next().text("*确认密码不能为空！");
        }else if($("#password2").val() != $("#password").val()){
            $("span").text("");
            $("#password2").next().text("*密码与确认密码不一致！");
        }else if(!(/^1[34578]\d{9}$/.test($("#phoneNumber").val()))){
            $("span").text("");
            $("#phoneNumber").next().text("电话格式不正确！");
        }else {
            $.ajax({
                type : "POST",
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                url : path + "/user/checkUser",
                data : {
                    newUserName : $("#userName").val()
                },
                success : function(data) {
                    data = $.parseJSON(data);
                    if(data == 1){
                        $("#registerForm").submit();
                    }else {
                        $("span").text("");
                        $("#userName").next().text("*用户名已存在！");
                    }
                }
            });

        }
    });

});