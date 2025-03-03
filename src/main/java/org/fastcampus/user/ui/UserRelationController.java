package org.fastcampus.user.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.JPA.JpaUserListQueryRepository;
import org.fastcampus.common.ui.Response;
import org.fastcampus.user.application.UserRelationService;
import org.fastcampus.user.application.dtos.FollowUserRequestDto;
import org.fastcampus.user.application.dtos.GetUserListResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-relation")
@RequiredArgsConstructor
public class UserRelationController {

    private final UserRelationService userRelationService;
    private final JpaUserListQueryRepository jpaUserListQueryRepository;

    @PostMapping("/follow")
    public Response<Void> follow(@RequestBody FollowUserRequestDto followUserRequestDto) {
        userRelationService.follow(followUserRequestDto);
        return Response.ok(null);

    }

    @PostMapping("/unfollow")
    public Response<Void> unfollow(@RequestBody FollowUserRequestDto followUserRequestDto) {
        userRelationService.unfollow(followUserRequestDto);
        return Response.ok(null);

    }

    @GetMapping("/{userId}/follower")
    public Response<List<GetUserListResponseDto>> getFollwerList(@PathVariable(name ="userId")Long userId) {
        List<GetUserListResponseDto> result = jpaUserListQueryRepository.getFollowerUserList(userId);
        return Response.ok(result);

    }

    @GetMapping("/{userId}/following")
    public Response<List<GetUserListResponseDto>> getFollwingList(@PathVariable(name ="userId")Long userId) {
        List<GetUserListResponseDto> result = jpaUserListQueryRepository.getFollowingUserList(userId);
        return Response.ok(result);

    }
}
