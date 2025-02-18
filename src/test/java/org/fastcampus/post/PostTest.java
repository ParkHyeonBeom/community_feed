package org.fastcampus.post;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.PostPublicationStatus;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.repository.FakeUserRepository;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostTest {

    private final FakeUserRepository fakeUserRepository = new FakeUserRepository();

    User user1;
    User user2;
    User user3;

    @BeforeEach
    void init(){
        UserInfo userInfo1 = new UserInfo("박현범","");
        UserInfo userInfo2 = new UserInfo("주혜빈", "");

        user1 = new User(null,userInfo1);
        user2 = new User(null,userInfo2);

        fakeUserRepository.save(user1);
        fakeUserRepository.save(user2);

    }


    @Test
    public void givenUser_whenCreatePost_thenSuccess() {

        PostContent postContent = new PostContent("abcdef");

        // given
        Post post = new Post(1L, user1,postContent);

        // when
        Assertions.assertEquals(1L,post.getId());
        Assertions.assertEquals(user1,post.getAuthor());
        Assertions.assertEquals(postContent.getContentText(),post.getContent().getContentText());

    }

    @Test
    public void givenUnvalidUser_whenCreatePost_thenSuccess() {

        PostContent postContent = new PostContent("abcdef");

        // given, when, then
        Assertions.assertThrows(IllegalArgumentException.class,()->new Post(3L, user3,postContent));
    }

    @Test
    public void givenPost_whenLike_thenSuccess() {

        PostContent postContent = new PostContent("abcdef");

        // given
        Post post = new Post(1L, user1,postContent);

        // when
        post.like(user2);

        // then
        Assertions.assertEquals(1,post.getLikeCount().getCount());

    }

    @Test
    public void givenPost_whenUnLike_thenSuccess() {

        PostContent postContent = new PostContent("abcdef");

        // given
        Post post = new Post(1L, user1,postContent);

        // when
        post.like(user2);
        post.unLike();

        // then
        Assertions.assertEquals(0,post.getLikeCount().getCount());

    }

    @Test
    public void givenPost_whenUpdatePost_thenSuccess() {

        PostContent postContent = new PostContent("abcdef");

        // given
        Post post = new Post(1L, user1,postContent);

        // when
        post.updateContent(user1,"abcdefg", PostPublicationStatus.Pulbic);

        // then
        Assertions.assertEquals("abcdefg",post.getContent().getContentText());
        Assertions.assertEquals(PostPublicationStatus.Pulbic,post.getStatus());

    }



}
