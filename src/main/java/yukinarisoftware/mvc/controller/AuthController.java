package yukinarisoftware.mvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AuthController {

    @PostMapping(path = "/auth/login" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse response
    ) {
            if ("yuki".equals(username) && "root".equals(password)) {
                Cookie cookie = new Cookie("username", username);
                cookie.setPath("/");
                response.addCookie(cookie);
                return new ResponseEntity<>("ok", HttpStatus.OK);
            } else  {
                return new ResponseEntity<>("error", HttpStatus.UNAUTHORIZED);
            }
    }

    @GetMapping(path = "/auth/user")
    public ResponseEntity<String> getUserCookie(@CookieValue(name = "username") String username) {

        return new ResponseEntity<>("hello " + username, HttpStatus.OK);

    }
}
