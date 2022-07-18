package study.validation.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import study.validation.dto.InputWithGroups;
import study.validation.group.OnCreate;
import study.validation.group.OnUpdate;

import javax.validation.Valid;

@Service
@Validated
public class ValidatingServiceWithGroups {

    @Validated(OnCreate.class)
    public void validateForCreate(@Valid InputWithGroups input) {
        // do something
    }

    @Validated(OnUpdate.class)
    public void validateForUpdate(@Valid InputWithGroups input) {
        // do something
    }
}
