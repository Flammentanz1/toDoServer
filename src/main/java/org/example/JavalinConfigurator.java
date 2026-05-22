package org.example;
import io.javalin.config.JavalinConfig;
//57

public class JavalinConfigurator {

    public static void configureJavalin(JavalinConfig javalinConfig) {
        var controller = new ServerController();
        javalinConfig.staticFiles.enableWebjars();
        javalinConfig.routes.get("/todos", controller::showApp);
        javalinConfig.routes.post("/todos/new", controller::addToDo);
        javalinConfig.routes.post("/todos/{id}/delete", controller::deleteToDo);
        javalinConfig.routes.post("/todos/{id}/toggle", controller::toggleToDo);
        javalinConfig.routes.post("/todos/clearCompletedToDos", controller::clearCompletedToDos);
        javalinConfig.routes.post("/todos/setFilter/{filter}", controller::setFilter);
        javalinConfig.routes.get("todos/{id}/edit", controller::showEditForm);
        javalinConfig.routes.post("todos/{id}/edit", controller::updateTextOfToDo);
    }
}
