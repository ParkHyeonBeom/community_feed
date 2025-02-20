package org.fastcampus.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.fastcampus.user.repository.FakeUserRepository;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRepository;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    // given
    CreateUserRequestDto dto = new CreateUserRequestDto("name", "profileImageUrl");
    CreateUserRequestDto dto2 = new CreateUserRequestDto("name2", "profileImageUrl2");


    @Test
    void givenTwoUser_WhenCreate_ThenDifferentUserId(){

        // when
        User test1 = userService.create(dto);
        User test2 = userService.create(dto2);

        // then
        assertEquals(1,test1.getId());
        assertEquals(2,test2.getId());

        assertNotEquals(userRepository.findByUserId(test1.getId()),userRepository.findByUserId(test2.getId()));

        assertEquals("name",test1.getUserInfo().getName());

    }

}
