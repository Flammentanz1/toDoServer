@import org.example.Utils
@import org.example.ToDo

@param ToDo toDo
<li id="todo${toDo.id()}"
    class="${Utils.statusToCompleted(toDo.completed())}">
    <input
        hx-post="/todos/${toDo.id()}/toggle"
        hx-target="#todoapp"
        class="toggle"
        type="checkbox"
        checked="${toDo.completed()}"/>
    <label
        hx-get="/todos/${toDo.id()}/edit"
        hx-target="#todo${toDo.id()}"
        hx-swap="outerHTML"
    > ${toDo.text()}
    </label>
    <button
        hx-post="/todos/${toDo.id()}/delete"
        hx-target="#todoapp"
        class="destroy">
    </button>
</li>