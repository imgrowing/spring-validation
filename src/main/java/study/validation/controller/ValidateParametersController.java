package study.validation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@RestController
@Validated
public class ValidateParametersController {

    @GetMapping("/validatePathVariable/{id}")
    public ResponseEntity<String> validatePathVariable(
            @PathVariable("id") @Min(5) int id
    ) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameter")
    public ResponseEntity<String> validateRequestParameter(
            @RequestParam("param") @Min(5) int param
    ) {
        return ResponseEntity.ok("valid");
    }

    /* Global @ControllerAdvice를 적용하기 위해 주석 처리함
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    */
}
