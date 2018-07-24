$(function () {
    var deleteId = "";
    $(".table_box tr").click(function () {
        if($(this).attr("id") != "head_tr"){
            $(this).siblings().css("background", "white");
            $(this).css("background", "red");
            var value = $(this).find("#todoItemId").val();
            deleteId = value;
            $("#update").attr("href", path + "/todoItem/toUpdateTodoItem?todoItemId=" + value);
            $("#delete").attr("href", path + "/todoItem/deleteTodoItemByTodoItemId?todoItemId=" + value);
        }
    });
    $("#delete").click(function () {
        if(isNaN(deleteId)){
            alert("请选择一个代办事项！");
            $("#delete").attr("href", "#");
        }
    })

});