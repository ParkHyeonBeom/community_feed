package org.fastcampus.user.repository;

import java.util.Optional;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByUserId(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {

        return null;

    }

}
