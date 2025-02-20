package org.fastcampus.user.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.user.repository.FakeUserRelationRepository;
import org.fastcampus.user.repository.FakeUserRepository;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.application.dtos.FollowUserRequestDto;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRelationRepository;
import org.fastcampus.user.domain.interfaces.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRelationServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();
    private final UserRelationService userRelationService = FakeObjectFactory.getUserRelationService();

    private User user ;
    private User user2 ;

    private FollowUserRequestDto followRequestDto;


    @BeforeEach
    void init(){

        CreateUserRequestDto dto = new CreateUserRequestDto("name", "profileImageUrl");
        CreateUserRequestDto dto2 = new CreateUserRequestDto("name2", "profileImageUrl2");

        this.user = userService.create(dto);
        this.user2 = userService.create(dto2);

        this.followRequestDto = new FollowUserRequestDto(user.getId(), user2.getId());

    }

    @Test
    void givenTwoUsers_whenFollow_thenSuccess(){

        // when
        userRelationService.follow(followRequestDto);
        
        // then
        Assertions.assertEquals(1,user.getFollowingCount());
        Assertions.assertEquals(1,user2.getFollowerCount());

    }

    @Test
    void givenTwoUsers_whenUnFollow_thenSuccess(){

        // when
        userRelationService.follow(followRequestDto);
        userRelationService.unfollow(followRequestDto);

        // then
        Assertions.assertEquals(0,user.getFollowingCount());
        Assertions.assertEquals(0,user2.getFollowingCount());
        Assertions.assertEquals(0,user.getFollowerCount());
        Assertions.assertEquals(0,user2.getFollowerCount());

    }

    @Test
    void givenTwoUsers_whenFollowAgain_thenThrowException(){

        // when
        userRelationService.follow(followRequestDto);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userRelationService.follow(followRequestDto);
        });

    }

    @Test
    void givenOneUsers_whenFollowSelf_thenThrowException(){

        // given
        FollowUserRequestDto followUserRequestDto = new FollowUserRequestDto(user.getId(), user.getId());

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userRelationService.follow(followUserRequestDto);
        });

    }

}
