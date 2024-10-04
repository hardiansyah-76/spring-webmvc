package yukinarisoftware.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping(path = "/error")
    public ResponseEntity<String> errorPage(HttpServletRequest request) {
       Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
       String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

       String html = """
               <html>
               <body>
               <h1>$status - $message</h1>
               </body>
               </html>
               """.replace("$status", statusCode.toString()).replace("$message", message.toString());

       return ResponseEntity.status(statusCode).body(html);
    }
}
