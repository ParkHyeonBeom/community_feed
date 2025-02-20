package org.fastcampus.fake;

import org.fastcampus.post.application.CommentService;
import org.fastcampus.post.application.PostService;
import org.fastcampus.post.domain.FakeCommentRepository;
import org.fastcampus.post.domain.FakeLikeRepository;
import org.fastcampus.post.repository.CommentRepository;
import org.fastcampus.post.repository.FakePostRepository;
import org.fastcampus.post.repository.LikeRepository;
import org.fastcampus.post.repository.PostRepository;
import org.fastcampus.user.repository.FakeUserRelationRepository;
import org.fastcampus.user.repository.FakeUserRepository;
import org.fastcampus.user.application.UserRelationService;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.domain.interfaces.UserRelationRepository;
import org.fastcampus.user.domain.interfaces.UserRepository;

public class FakeObjectFactory {

    private static final UserRepository userRepository = new FakeUserRepository();
    private static final UserRelationRepository userRelationRepository = new FakeUserRelationRepository();
    private static final PostRepository postRepository = new FakePostRepository();
    private static final CommentRepository commentRepository = new FakeCommentRepository();
    private static final LikeRepository likeRepository = new FakeLikeRepository();

    private static final UserService userService = new UserService(userRepository);
    private static final UserRelationService userRelationService = new UserRelationService(userService,userRelationRepository);
    private static final PostService postService = new PostService(userService,postRepository,likeRepository);
    private static final CommentService commentService = new CommentService(userService,postService,commentRepository,likeRepository);

    private FakeObjectFactory(){}

    public static UserService getUserService(){
        return userService;
    }

    public static UserRelationService getUserRelationService(){
        return userRelationService;
    }

    public static PostService getPostService(){
        return postService;
    }

    public static CommentService getCommentService(){
        return commentService;
    }
}
