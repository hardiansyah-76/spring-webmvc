package yukinarisoftware.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import yukinarisoftware.mvc.model.CreatePersonRequest;

@Controller
public class PersonController {

    /*
     * MODEL ATTRIBUTE
     * */

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createPerson(@ModelAttribute(name = "request") @Valid CreatePersonRequest request) {

        String response = new StringBuilder().append("success create person ")
                .append(request.getFirstName()).append(" ")
                .append(request.getLastName())
                .append(" with email ").append(request.getEmail())
                .append(" and phone ").append(request.getPhone())
                .append(" city ").append(request.getAddress().getCity())
                .append(" country ").append(request.getAddress().getCountry())
                .toString();

        return ResponseEntity.ok(response);
    }
}
