package org.fastcampus.post.domain.content;

public class PostContent extends Content {

    private static final long MIN_POST_LENGTH = 5;
    private static final long MAX_POST_LENGTH = 500;

    public PostContent(String content) {
        super(content);
    }


    @Override
    public void checkText(String contentText) {

        if (contentText == null || contentText.isEmpty())
            throw new IllegalArgumentException("에러");

        if (contentText.length() < MIN_POST_LENGTH )
            throw new IllegalArgumentException("글자수 부족");

        if (contentText.length() > MAX_POST_LENGTH )
            throw new IllegalArgumentException("글자수 초과");

    }

}
