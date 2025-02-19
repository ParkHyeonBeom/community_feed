package org.fastcampus.post;

public record UpdateCommentRequestDto(Long commentId, Long userId, String content) {
}
