package org.fastcampus.JPA;

import java.util.List;
import org.fastcampus.user.application.dtos.GetUserListResponseDto;
import org.fastcampus.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaUserListQueryRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select new org.fastcampus.user.application.dtos.GetUserListResponseDto(u.name, u.profileImage) "
            + "from UserRelationEntity ur "
            + "Inner join UserEntity u on ur.followerId = u.id "
            + "Where ur.followingId = :userId")
    List<GetUserListResponseDto> getFollowingUserList(Long userId);


    @Query(value = "Select new org.fastcampus.user.application.dtos.GetUserListResponseDto(u.name, u.profileImage) "
            + "from UserRelationEntity ur "
            + "Inner join UserEntity u on ur.followingId = u.id "
            + "Where ur.followerId = :userId")
    List<GetUserListResponseDto>getFollowerUserList(Long userId);
}
