package org.fastcampus.user.domain.interfaces;

import java.util.Optional;
import org.fastcampus.user.domain.User;

public interface UserRepository {

    User save(User user);
    Optional<User> findByUserId(Long id);

}
