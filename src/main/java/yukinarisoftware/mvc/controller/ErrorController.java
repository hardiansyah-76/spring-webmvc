package yukinarisoftware.mvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("validation error : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("validation error : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
