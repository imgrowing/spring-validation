package study.validation.dto;

import study.validation.group.OnCreate;
import study.validation.group.OnUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class InputWithGroups {

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
