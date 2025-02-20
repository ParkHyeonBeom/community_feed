package org.fastcampus.post.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.content.Content;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;

public class Post {

    private final Long id;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationStatus status;

    public Post(Long id, User author, Content content) {
        this(id, author, content, PostPublicationStatus.Pulbic);
    }

    public Post(Long postId, User author, Content content, PostPublicationStatus status) {

        if(author == null)
            throw new IllegalArgumentException("존재하지 않는 회원");

        this.id = postId;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.status = status;
    }

    public static Post createPost(Long id, User author, String content, PostPublicationStatus status) {
        return new Post(id, author, new PostContent(content), status);
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

    public void updateContent(User user, String updateContentText, PostPublicationStatus status) {
        if(!this.author.equals(user)){
            throw new IllegalArgumentException("");
        }
        this.content.updateContent(updateContentText);
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }

    public PositiveIntegerCounter getLikeCount() {
        return likeCount;
    }

    public int getLikeCountInt() {
        return likeCount.getCount();
    }

    public PostPublicationStatus getStatus() {
        return status;
    }
}
