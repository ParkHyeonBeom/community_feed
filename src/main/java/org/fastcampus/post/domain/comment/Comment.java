package org.fastcampus.post.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.CommentContent;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

@Builder
@AllArgsConstructor
@Getter
public class Comment {

    private Long id;
    private Post post;
    private User author;
    private CommentContent content;
    private PositiveIntegerCounter likeCount;

    public static Comment createComment(Post post, User author, CommentContent content) {
        return new Comment(null, post, author, content);
    }

    public Comment(Long id, Post post, User author, CommentContent content) {

        if(post == null)
            throw new IllegalArgumentException();

        if(author == null)
            throw new IllegalArgumentException();

        if(content == null)
            throw new IllegalArgumentException();

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if(this.author.equals(user)){
            throw new IllegalArgumentException("동일한 유저");
        }
        likeCount.increaseCount();
    }

    public void unLike() {
        likeCount.decreaseCount();
    }

    public void updateContent(User user, String updateContentText) {
        if(!this.author.equals(user)){
            throw new IllegalArgumentException("");
        }
        this.content.updateContent(updateContentText);
    }

    public String getContent() {
        return content.getContentText();
    }

    public int getLikeCount() {
        return likeCount.getCount();
    }
}
