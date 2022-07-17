package study.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.validation.dto.Input;

public interface ValidatingRepository extends JpaRepository<Input, Long> {
}
