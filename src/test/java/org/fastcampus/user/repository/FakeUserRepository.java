package org.fastcampus.user.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRepository;

public class FakeUserRepository implements UserRepository {

    private final Map<Long,User> Store = new HashMap<>();

    @Override
    public Optional<User> findByUserId(Long id) {
        return Optional.ofNullable(Store.get(id));
    }

    @Override
    public User save(User user) {

        Long id = Store.size() + 1L;

        User newUser = new User(id,user.getUserInfo());

        Store.put(id, newUser);

        return Store.get(id);
    }
}
