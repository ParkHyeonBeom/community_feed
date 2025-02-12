package org.fastcampus.post.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

public class Post {

    private Long id;
    private User author;
    private PostContent content;
    private PositiveIntegerCounter likeCount;

    public Post(Long postId, User author, PostContent content) {

        if(author == null)
            throw new IllegalArgumentException("존재하지 않는 회원");

        this.id = postId;
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
