package org.example;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import gg.jte.resolve.ResourceCodeResolver;

import java.nio.file.Path;

import static java.lang.IO.println;

public class
TemplateRenderer {
    private TemplateEngine htmlTemplateEngine;

    public TemplateRenderer() {
        CodeResolver htmlCodeResolver = new DirectoryCodeResolver(Path.of("src/main/resources/jte/web"));
        boolean deploy = true;
        if(deploy) {
            htmlCodeResolver = new ResourceCodeResolver("jte/web");
        }
        htmlTemplateEngine = TemplateEngine.create(htmlCodeResolver, ContentType.Html);
    }

    private <T> String renderToString(T object, String templateName) {
        StringOutput stringOutput = new StringOutput();
        htmlTemplateEngine.render(templateName + ".jte", object, stringOutput);
        return stringOutput.toString();
    }

    public String renderAppToString(UIState uiState, Boolean partial) {
        if (partial) {
            return renderToString(uiState, "app");
        }
        else {
            return renderToString(uiState, "mainPage");
        }
    }

    public String renderToDoToString(ToDo toDo, Boolean editing) {
        if (editing) {
            return renderToString(toDo, "editingForm");
        }
        else {
            return renderToString(toDo, "toDo");
        }
    }
}
