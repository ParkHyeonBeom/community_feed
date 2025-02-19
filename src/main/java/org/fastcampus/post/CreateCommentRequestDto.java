package org.fastcampus.post;

public record CreateCommentRequestDto(Long postId, Long userId, String content) {
}
