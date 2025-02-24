package org.fastcampus.post.model.post;

import jakarta.persistence.AttributeConverter;
import org.fastcampus.post.domain.PostPublicationStatus;

public class PostPublicationStatusConverter implements AttributeConverter<PostPublicationStatus, String> {

    @Override
    public String convertToDatabaseColumn(PostPublicationStatus postPublicationStatus) {
        return postPublicationStatus.name();
    }

    @Override
    public PostPublicationStatus convertToEntityAttribute(String s) {
        return PostPublicationStatus.valueOf(s);
    }
}
