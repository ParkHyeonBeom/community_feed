package org.fastcampus.user.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.fastcampus.common.ui.Response;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.application.dtos.GetUserProfileResponseDto;
import org.fastcampus.user.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Response<Long> createUser(@RequestBody CreateUserRequestDto dto) {
        User user = userService.create(dto);
        return Response.ok(user.getId());
    }

    @GetMapping("/{userId}/profile")
    public GetUserProfileResponseDto getProfile(@PathVariable(name = "userId") Long userId) {
        return userService.getProfile(userId);
    }
}
