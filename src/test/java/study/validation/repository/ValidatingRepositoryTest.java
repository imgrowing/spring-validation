package study.validation.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.validation.dto.Input;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ValidatingRepositoryTest {

    @Autowired
    private ValidatingRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void whenInputIsInvalid_thenThrowsException() {
        Input input = invalidInput();

        assertThrows(ConstraintViolationException.class, () -> {
            //repository.save(input);
            //entityManager.flush();

            //repository.save(input);
            //repository.flush();

            repository.saveAndFlush(input);
        });
    }

    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
    }

}