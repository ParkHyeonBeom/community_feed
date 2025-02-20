package org.fastcampus.post;

import org.fastcampus.post.domain.PostPublicationStatus;

public record CreatePostRequestDto(Long userId, String content, PostPublicationStatus status) {
}
