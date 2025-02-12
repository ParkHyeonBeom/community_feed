package org.fastcampus.post.domain.comment;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.CommentContent;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

public class Comment {

    private Long id;
    private Post post;
    private User author;
    private CommentContent content;
    private PositiveIntegerCounter likeCount;

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


}
