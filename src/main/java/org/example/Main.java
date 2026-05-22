import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.Javalin;
import org.example.*;

import static java.lang.IO.println;

void main() {
    Javalin app = Javalin.create(JavalinConfigurator::configureJavalin);
    String port = System.getenv().getOrDefault("PORT", "8080");
    int portInt = Integer.parseInt(port);
    app.start(8080);
}


