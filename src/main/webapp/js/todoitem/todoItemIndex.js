$(function () {

    $(".table_box tr").click(function () {
        $(this).siblings().css("background", "white");
        $(this).css("background", "red");
        var value = $(this).find("#todoItemId").text();
        $("#update").attr("href", path + "/todoItem/toUpdateTodoItem?todoItemId=" + value);
        $("#delete").attr("href", path + "/todoItem/deleteTodoItemByTodoItemId?todoItemId=" + value);
    })

});