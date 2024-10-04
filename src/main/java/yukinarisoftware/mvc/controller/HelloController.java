package yukinarisoftware.mvc.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello(
            @RequestParam(name = "name", required = false) String name) throws Exception {

        if (name == null) {
            return "hello guest";
        } else {
            return "hello " + name;
        }
    }

    /*REQUEST CONTENT TYPE
     * EXAMPLE FORM APPLICATION
     * and Response HTML
     * */

    @ResponseBody
    @PostMapping(
            path = "/form/hello",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String hello(@RequestParam(name = "name") String name) {

        return """
                <html>
                <body>
                <h1>hello $name</h1>
                </body>
                </html>
                """.replace("$name", name);
    }



    @GetMapping(path = "/web/hello")
    @ResponseBody
    public ModelAndView helloModelView(@RequestParam(name = "name", required = false) String name) {

        if (Objects.isNull(name)) {
            return new ModelAndView("redirect:/web/hello?name=guest");
        }

        return new ModelAndView("hello", Map.of(
                "title", "belajar view",
                "name", name
        ));

    }
}
