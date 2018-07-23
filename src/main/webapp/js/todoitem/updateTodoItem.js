$(function () {
    $("#update").click(function () {
        if($("#todoItemTitle").val() == ""){
            $("#todoItemTitle").next().text("*标题不能为空！");
        }else {
            $("#updateForm").submit();
        }
    });

    $("#cancer").click(function () {
        $(location).attr("href", path + "/todoItem/todoItemIndex");
    });

});