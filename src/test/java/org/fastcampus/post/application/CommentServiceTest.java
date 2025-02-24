package org.fastcampus.post.application;

import org.fastcampus.post.LikeRequestDto;
import org.fastcampus.post.UpdateCommentRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.comment.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentServiceTest extends PostApplicationTestTemplate {

    @Test
    void givenCreateCommentRequestDto_whenCreateComment_thenReturnComment() {
        // given , when
        Comment comment = commentService.createComment(dtoComment);
        Comment result = commentService.getComment(comment.getId());

        // then
        Assertions.assertEquals(comment, result);
    }

    @Test
    void givenUpdateCommentRequestDto_whenUpdateComment_thenReturnUpdatedComment() {
        // given
        Comment comment = commentService.createComment(dtoComment);

        String updatedContent = "updated content";

        commentService.updateComment(new UpdateCommentRequestDto(comment.getId(), user.getId(), updatedContent));

        // when
        Comment result = commentService.getComment(comment.getId());

        // then
        Assertions.assertEquals(updatedContent, result.getContent());
    }

    @Test
    void givenPostAndComment_whenLikeComment_thenLike1() {
        // given
        Comment comment = commentService.createComment(dtoComment);

        // when
        commentService.likeComment(new LikeRequestDto(comment.getId(), user2.getId()));

        // then
        Assertions.assertEquals(1, comment.getLikeCount());
    }


}
