package org.fastcampus.JPA;

import java.util.Optional;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
