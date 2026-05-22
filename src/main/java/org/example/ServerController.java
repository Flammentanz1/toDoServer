package org.example;
import io.javalin.http.Context;

import static java.lang.IO.println;


public class ServerController {
    Model model = new Model();
    ServerView serverView = new ServerView();

    public void showApp(Context ctx) {
        var uiState = model.getUIState();
        serverView.showApp(ctx, uiState);
    }

    public void addToDo(Context ctx) {
        String newToDo = ctx.formParam("text_of_new_todo");
        model.add(newToDo);
        showApp(ctx);
    }

    public void deleteToDo(Context ctx) {
        var id = Integer.parseInt(ctx.pathParam("id"));
        model.delete(id);
        showApp(ctx);
    }

    public void toggleToDo(Context ctx) {
        var id = Integer.parseInt(ctx.pathParam("id"));
        model.toggle(id);
        showApp(ctx);
    }

    public void clearCompletedToDos(Context ctx) {
        model.removeFinishedToDoItems();
        showApp(ctx);
    }

    public void setFilter(Context ctx) {
        var filter = ctx.pathParam("filter");
        model.setFilter(filter);
        showApp(ctx);
    }

    public void showEditForm(Context ctx) {
        var id = Integer.parseInt(ctx.pathParam("id"));
        var toDo = model.getToDoItem(id);
        serverView.showToDo(ctx, toDo, true);
    }

    public void updateTextOfToDo(Context ctx) {
        var newText = ctx.formParam("updated_text_of_new_todo");
        var id = Integer.parseInt(ctx.pathParam("id"));
        model.updateText(id, newText);
        var toDo = model.getToDoItem(id);
        serverView.showToDo(ctx, toDo, false);
    }
}

