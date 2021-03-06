package study.validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.validation.dto.Input;
import study.validation.dto.InputWithCustomValidator;

import javax.validation.Valid;

@RestController
public class ValidateRequestBodyController {

    @PostMapping("/validateBody")
    public ResponseEntity<String> validateBody(@Valid @RequestBody Input input) {
        return ResponseEntity.ok("valid");
    }

    @PostMapping("/validateBodyWithCustomValidator")
    public ResponseEntity<String> validateBody(@Valid @RequestBody InputWithCustomValidator input) {
        return ResponseEntity.ok("valid");
    }

}
