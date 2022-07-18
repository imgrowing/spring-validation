package study.validation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.validation.dto.InputWithGroups;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidatingServiceWithGroupsTest {

    @Autowired
    private ValidatingServiceWithGroups service;

    @Test
    public void whenInputIsInvalidForCreate_thenThrowsException() {
        InputWithGroups input = new InputWithGroups();
        input.setId(42L);

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateForCreate(input);
        });
    }

    @Test
    public void whenInputIsInvalidForUpdate_thenThrowsException() {
        InputWithGroups input = new InputWithGroups();
        input.setId(null);

        assertThrows(ConstraintViolationException.class, () -> {
            service.validateForUpdate(input);
        });
    }

}