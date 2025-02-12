package org.fastcampus.post.domain.content;

public abstract class Content {

    String contentText;

    protected Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
    }

    protected abstract void checkText(String contentText);

}
