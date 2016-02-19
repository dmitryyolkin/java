/**
 * Created by dmitry on 16.02.16.
 */
'use strict';

function showAllTodos() {
    //jQuery
    $.ajax({
        url: "./servlets/todos",
        type: "GET",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            var $allTodos = $("#allTodos");
            $allTodos.html("<p>" + "All is ok: " + textStatus + "</p>");

            if (data != null && data != undefined && data.length > 0){
                $allTodos.attr("class", "non-empty-todo");
                data.forEach(function(todo){
                    $allTodos.append(
                        "<div>" +
                        "id: " + todo.id + "; " +
                        "summary: " + todo.summary + "; " +
                        "description: " + todo.description + "; " +
                        "</div>>"
                    );
                });
            }else{
                $allTodos.attr("class", "empty-todo");
            }
        },
        error: function (jqXHR, textStatus) {
            $("#allTodos").html("<p>" + "No ability to get all Todos because " + textStatus + "</p>");
        }
    });
}

function makeCreateFormVisible(){
    var $obj = $("#createTodoForm");
    if ($obj.attr("class") == "invisible"){
        $obj.attr("class", "visible");
    }else{
        $obj.attr("class", "invisible");
    }
}

function createTodo() {
    //send new object to server with ajax
    var $createTodoForm = $("#createTodoForm");
    $.ajax({
        url: "./servlets/todos",
        type: "POST",
        data: JSON.stringify({
            "id": $createTodoForm.find('input[name="id"]').val(),
            "summary": $createTodoForm.find('input[name="summary"]').val(),
            "description": $createTodoForm.find('textarea[name="description"]').val()
        }),
        contentType: "application/json",
        dataType: "json",
        cache: false,
        success: function(data, textStatus, jqXHR){
            console.log(textStatus);
        }
    });

    //clear and close form
    $createTodoForm.trigger("reset");
    $createTodoForm.attr("class", "invisible");
}
