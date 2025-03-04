package org.fastcampus.post.application;

import org.fastcampus.post.CommentPostRequestDto;
import org.fastcampus.post.CreatePostRequestDto;
import org.fastcampus.post.LikeRequestDto;
import org.fastcampus.post.UpdatePostRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.repository.LikeRepository;
import org.fastcampus.post.repository.PostRepository;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.domain.User;

public class PostService {

    private final UserService userService;

    private final PostRepository postRepository;

    private final LikeRepository likeRepository;

    public PostService(UserService userService, PostRepository postRepository, LikeRepository likeRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.userId());
        Post post = Post.createPost(null,author, dto.content(),dto.status());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, CreatePostRequestDto dto) {

        Post post = getPost(id);

        User author = userService.getUser(dto.userId());

        post.updateContent(author, dto.content(),dto.status());

        return postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post, user)){
            return;
        }

        post.like(user);
        likeRepository.like(post,user);

    }

    public void unLikePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post, user)){
            post.unLike();
            likeRepository.unlike(post,user);
        }
    }


}
