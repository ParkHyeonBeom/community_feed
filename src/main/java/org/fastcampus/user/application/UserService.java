package org.fastcampus.user.application;

import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.fastcampus.user.domain.interfaces.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(CreateUserRequestDto dto) {

        UserInfo userInfo = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null,userInfo);

        return userRepository.save(user);

    }

    public User getUser(Long userId) {
        return userRepository.findByUserId(userId).orElseThrow(IllegalArgumentException::new);
    }

}
