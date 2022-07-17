package study.validation.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.validation.dto.Input;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProgrammaticallyValidatingServiceTest {

    @Autowired
    private ProgrammaticallyValidatingService service;

    @Test
    public void whenInputIsInvalid_thenThrowsException() {
        Input input = invalidInput();

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInput(input);
        });
    }

    @Test
    public void givenInjectedValidator_whenInputIsInvalid_thenThrowsException() {
        Input input = invalidInput();

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInputWithInjectedValidator(input);
        });
    }

    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
    }

}