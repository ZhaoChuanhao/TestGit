$(function () {
    $("#add").click(function () {
        if($("#todoItemTitle").val() == ""){
            $("#todoItemTitle").next().text("标题不能为空");
        }else {
            $("#addForm").submit();
        }
    });

    $("#cancer").click(function () {
        $(location).attr("href", path + "/todoItem/todoItemIndex");
    });

});