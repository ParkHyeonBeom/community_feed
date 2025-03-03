package org.fastcampus.user.application;

import lombok.RequiredArgsConstructor;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.application.dtos.GetUserProfileResponseDto;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.fastcampus.user.domain.interfaces.UserRepository;
import org.fastcampus.user.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(CreateUserRequestDto dto) {

        UserInfo userInfo = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null,userInfo);

        return userRepository.save(user);

    }

    public GetUserProfileResponseDto getProfile(Long id) {
        GetUserProfileResponseDto getUserProfileResponseDto = new GetUserProfileResponseDto(getUser(id));
        return getUserProfileResponseDto;
    }

    public User getUser(Long userId) {
        return userRepository.findByUserId(userId);
    }

}
