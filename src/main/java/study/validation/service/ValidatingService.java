package study.validation.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import study.validation.dto.Input;

import javax.validation.Valid;

@Service
@Validated
public class ValidatingService {

    public void validateInput(@Valid Input input) {
        // do something
    }

}
