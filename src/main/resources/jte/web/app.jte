@import org.example.ToDo
@import org.example.UIState
@import org.example.Utils
@import org.example.TemplateRenderer

@param UIState uiState

<header class="header">
    <h1>todos</h1>
    <form action="/todos/new"
            hx-target="#todoapp"
            method="post">
        <input
            class="new-todo"
            placeholder="What needs to be done?"
            name="text_of_new_todo"
            autofocus>
        <button type="submit"
            style="display:none;"
            >
        Add
        </button>
    </form>
</header>
<main>
    <ul class="todo-list">
        @for (ToDo toDo : uiState.selectedToDos())
            @template.toDo(toDo = toDo)
        @endfor
    </ul>
</main>
<footer class="footer">
    <span class="todo-count">
    <strong>${uiState.displayOfActiveToDos()}</strong>
    </span>
    <ul class="filters">
        <li>
            <a class="${Utils.computeFilterClass(uiState.selectedFilter(), "All")}"
                hx-post="/todos/setFilter/All"
                hx-target="#todoapp"> All
            </a>
        </li>
        <li>
            <a class="${Utils.computeFilterClass(uiState.selectedFilter(), "Active")}"
                hx-post="/todos/setFilter/Active"
                hx-target="#todoapp"> Active </a>
        </li>
        <li>
            <a class="${Utils.computeFilterClass(uiState.selectedFilter(), "Completed")}"
                hx-post="/todos/setFilter/Completed"
                hx-target="#todoapp"> Completed </a>
        </li>
    </ul>
    <button
        hx-post="/todos/clearCompletedToDos"
        hx-target="#todoapp"
        class="clear-completed">
    Clear completed
    </button>
</footer>