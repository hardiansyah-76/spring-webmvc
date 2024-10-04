package yukinarisoftware.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import yukinarisoftware.mvc.model.User;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    public String user (@SessionAttribute(name = "user") User user) {

        return "hello " + user.getName();
    }
}
