package yukinarisoftware.mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {


    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @ResponseBody
    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPerson(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "birthdate") Date birthdate,
            @RequestParam(name = "address") String address
    ) {
        return "success create person, name " + name + ", birthdate " + dateFormat.format(birthdate) + ", address " + address;
    }
}
