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
class ValidatingServiceTest {

    @Autowired
    private ValidatingService service;

    @Test
    public void whenInputIsInvalid_thenThrowsException() {
        Input input = invalidInput();
        service.validateInput(input);
        assertThrows(ConstraintViolationException.class, () -> {
           service.validateInput(input);
        });
    }

    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
    }
}