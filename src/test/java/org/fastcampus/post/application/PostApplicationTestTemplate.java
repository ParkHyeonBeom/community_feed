package org.fastcampus.post.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.post.CreateCommentRequestDto;
import org.fastcampus.post.CreatePostRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.PostPublicationStatus;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.domain.User;

public class PostApplicationTestTemplate {

     final PostService postService = FakeObjectFactory.getPostService();
     final UserService userService = FakeObjectFactory.getUserService();
     final CommentService commentService = FakeObjectFactory.getCommentService();

     final User user = userService.create(new CreateUserRequestDto("name", ""));
     final User user2 = userService.create(new CreateUserRequestDto("name2", ""));
     final CreatePostRequestDto dtoPost = new CreatePostRequestDto(user.getId(), "content", PostPublicationStatus.Pulbic);

     final Post post = postService.createPost(dtoPost);

     final CreateCommentRequestDto dtoComment = new CreateCommentRequestDto(post.getId(), user.getId(), "content");

}
