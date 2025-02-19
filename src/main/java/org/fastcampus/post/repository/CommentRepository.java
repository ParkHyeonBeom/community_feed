package org.fastcampus.post.repository;

import java.util.Optional;
import org.fastcampus.post.domain.comment.Comment;

public interface CommentRepository {

    Comment save(Comment comment);
    Optional<Comment> findById(Long id);

}
