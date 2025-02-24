package org.fastcampus.post.model.like;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.model.TimeBaseEntity;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.comment.Comment;
import org.fastcampus.user.domain.User;

@Entity
@NoArgsConstructor
@Table(name = "community_like")
@Getter
public class LikeEntity extends TimeBaseEntity {

    @EmbeddedId
    private LikeIdEntity id;

    public LikeEntity(Post post, User author) {
        this.id = new LikeIdEntity(post.getId(), author.getId(), LikeTarget.Post.name());
    }

    public LikeEntity(Comment comment, User author) {
        this.id = new LikeIdEntity(comment.getId(), author.getId(), LikeTarget.Comment.name());
    }

}
