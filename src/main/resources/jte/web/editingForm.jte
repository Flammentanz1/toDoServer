@import org.example.ToDo
@param ToDo toDo

<li id="todo${toDo.id()}" class="editing">
    <input class="edit new-todo"
        hx-post="/todos/${toDo.id()}/edit"
        hx-target="#todo${toDo.id()}"
        hx-swap="outerHTML"
        hx-trigger="blur"
        autofocus
        value="${toDo.text()}"
        name="updated_text_of_new_todo"
    >
</li>