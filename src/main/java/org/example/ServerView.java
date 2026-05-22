package org.example;

import io.javalin.http.Context;

import static java.lang.IO.println;

public class ServerView {
    TemplateRenderer templateRenderer = new TemplateRenderer();

    private void setContentTypeAndSend(Context ctx, String answer) {
        ctx.contentType("text/html");
        ctx.result(answer);
    }

    public void showApp(Context ctx, UIState uiState) {
        var header = ctx.header("HX-Request");
        String answer = templateRenderer.renderAppToString(uiState, header != null);
        setContentTypeAndSend(ctx, answer);
    }

    public void showToDo(Context ctx, ToDo toDo, Boolean editing) {
            var answer = templateRenderer.renderToDoToString(toDo, editing);
            setContentTypeAndSend(ctx, answer);
    }
}

