package org.fastcampus.post.domain.content;

public class CommentContent extends Content {

    private static final long MAX_POST_LENGTH = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText.length() > MAX_POST_LENGTH)
            throw new IllegalArgumentException("글자수 초과");
    }
}
