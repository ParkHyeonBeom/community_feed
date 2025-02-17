package org.fastcampus.user.application;

import org.fastcampus.user.application.dtos.FollowUserRequestDto;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRelationRepository;
import org.fastcampus.user.domain.interfaces.UserRepository;

public class UserRelationService {

    private final UserService userService;
    private final UserRelationRepository userRelationRepository;

    public UserRelationService(UserService userService,
            UserRelationRepository userRelationRepository) {
        this.userService = userService;
        this.userRelationRepository = userRelationRepository;
    }

    public void follow(FollowUserRequestDto followUserRequestDto) {
        User user = userService.getUser(followUserRequestDto.userId());
        User targetUser = userService.getUser(followUserRequestDto.targetUserId());

        boolean result = userRelationRepository.isAlreadyFollow(user, targetUser);

        if (result) {
            throw new IllegalArgumentException("");
        }

        user.follow(targetUser);
        userRelationRepository.save(user, targetUser);

    }

    public void unfollow(FollowUserRequestDto followUserRequestDto) {
        User user = userService.getUser(followUserRequestDto.userId());
        User targetUser = userService.getUser(followUserRequestDto.targetUserId());

        boolean result = userRelationRepository.isAlreadyFollow(user, targetUser);

        if (!result) {
            throw new IllegalArgumentException("");
        }

        user.unfollow(targetUser);
        userRelationRepository.save(user, targetUser);

    }

}
