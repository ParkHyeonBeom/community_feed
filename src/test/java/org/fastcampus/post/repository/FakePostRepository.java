package org.fastcampus.post.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.fastcampus.post.domain.Post;

public class FakePostRepository implements PostRepository {

    private final Map<Long,Post> postMap = new HashMap<>();


    @Override
    public Post save(Post post) {
        if(post.getId() != null){
            postMap.put(post.getId(),post);
            return post;
        }

        Long id = postMap.size() + 1L;
        Post newPost = new Post(id,post.getAuthor(),post.getContent());

        postMap.put(id,newPost);

        return newPost;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(postMap.get(id));
    }
}
