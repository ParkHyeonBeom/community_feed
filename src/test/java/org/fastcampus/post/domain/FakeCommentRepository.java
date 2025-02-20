package org.fastcampus.post.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.fastcampus.post.domain.comment.Comment;
import org.fastcampus.post.repository.CommentRepository;

public class FakeCommentRepository implements CommentRepository {

    private final Map<Long, Comment> comments = new HashMap<>();

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != null) {
            comments.put(comment.getId(), comment);
            return comment;
        }

        Long id = (comments.size() + 1L);

        Comment newComment = new Comment(id, comment.getPost(), comment.getAuthor(), comment.getContent());
        comments.put(id, newComment);

        return newComment;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(comments.get(id));
    }

}
