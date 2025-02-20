package org.fastcampus.post.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.post.CreatePostRequestDto;
import org.fastcampus.post.LikeRequestDto;
import org.fastcampus.post.UpdatePostRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.PostPublicationStatus;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dtos.CreateUserRequestDto;
import org.fastcampus.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostServiceTest extends PostApplicationTestTemplate {

    @Test
    void givenCreatePostRequestDto_whenCreatePost_thenReturnPost() {
        // given , when
        Post post = postService.createPost(dtoPost);
        Post result = postService.getPost(post.getId());

        // then
        Assertions.assertEquals(post, result);
    }

    @Test
    void givenCreatePost_whenUpdate_thenPostContentIsSame() {
        // given
        Post post = postService.createPost(dtoPost);

        // when
        postService.updatePost(post.getId(), dtoPost);
        Post result = postService.getPost(post.getId());

        // then
        Assertions.assertEquals(post.getContent(), result.getContent());
    }

    @Test
    void givenPost_whenLike_thenPostLikeCountIsOne() {
        // given
        Post post = postService.createPost(dtoPost);

        // when
        LikeRequestDto likeRequestDto = new LikeRequestDto(post.getId(), user2.getId());
        postService.likePost(likeRequestDto);

        // then
        Assertions.assertEquals(1, post.getLikeCountInt());
    }

    @Test
    void givenPost_whenLikeTwice_thenPostLikeCountIsOne() {
        // given
        Post post = postService.createPost(dtoPost);

        // when
        LikeRequestDto likeRequestDto = new LikeRequestDto(post.getId(), user2.getId());
        postService.likePost(likeRequestDto);
        postService.likePost(likeRequestDto);

        // then
        Assertions.assertEquals(1, post.getLikeCountInt());
    }

    @Test
    void givenPostLiked_whenUnlike_thenPostLikeCountIsZero() {
        // given
        Post post = postService.createPost(dtoPost);
        LikeRequestDto likeRequestDto = new LikeRequestDto(post.getId(), user2.getId());
        postService.likePost(likeRequestDto);

        // when
        postService.unLikePost(likeRequestDto);

        // then
        Assertions.assertEquals(0, post.getLikeCountInt());
    }

    @Test
    void givenPost_whenUnlike_thenThrowExceoption() {
        // given
        Post post = postService.createPost(dtoPost);

        // when
        LikeRequestDto likeRequestDto = new LikeRequestDto(post.getId(), user2.getId());
        postService.unLikePost(likeRequestDto);

        // then
        Assertions.assertEquals(0, post.getLikeCountInt());
    }

}
