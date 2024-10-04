package yukinarisoftware.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
public class ResponseStatusController {

    @DeleteMapping("/products/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable(name = "id") Integer id) {
        //do anything, just example
        log.info("success delete");
    }
}
