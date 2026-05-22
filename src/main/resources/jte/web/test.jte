@import org.example.ToDo
@import org.example.UIState
@import org.example.Utils
@import org.example.TemplateRenderer

@param UIState uiState

            ${Utils.renderToString(uiState.selectedToDos().get(0), "toDo")}


        @for (ToDo toDo : uiState.selectedToDos())
            ${Utils.renderToString(toDo, "toDo")}
        @endfor
