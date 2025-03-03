package org.fastcampus.user.repository;

import lombok.RequiredArgsConstructor;
import org.fastcampus.JPA.JpaUserRepository;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRepository;
import org.fastcampus.user.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user);
        jpaUserRepository.save(userEntity);
        return userEntity.toUser();
    }

    @Override
    public User findByUserId(Long id) {
        UserEntity userEntity = jpaUserRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userEntity.toUser();
    }

}
