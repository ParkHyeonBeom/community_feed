package org.fastcampus.post;

public record CommentPostRequestDto(Long userId, Long postId, String content) {
}
