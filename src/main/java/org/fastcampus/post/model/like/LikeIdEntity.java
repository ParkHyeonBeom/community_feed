package org.fastcampus.post.model.like;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LikeIdEntity implements Serializable {
    private Long targetId;
    private Long userId;
    private String targetType;
}
