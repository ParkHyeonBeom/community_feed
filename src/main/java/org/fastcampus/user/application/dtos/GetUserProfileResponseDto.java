package org.fastcampus.user.application.dtos;

import org.fastcampus.user.domain.User;

public record GetUserProfileResponseDto(Long id, String name, String profileImageUrl , int follwerCount, int followingCount) {

    public GetUserProfileResponseDto(User user){
        this(user.getId(), user.getName(), user.getProfileImage(),user.getFollowerCount(),user.getFollowingCount());
    }
}
