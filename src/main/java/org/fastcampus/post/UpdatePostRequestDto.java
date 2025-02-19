package org.fastcampus.post;

import org.fastcampus.post.domain.PostPublicationStatus;

public record UpdatePostRequestDto(Long id, Long userId, String content, PostPublicationStatus status) {
}

