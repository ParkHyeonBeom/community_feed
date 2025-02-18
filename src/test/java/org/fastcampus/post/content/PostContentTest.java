package org.fastcampus.post.content;

import static org.junit.jupiter.api.Assertions.*;

import org.fastcampus.post.domain.content.PostContent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PostContentTest {

    @Test
    public void givenLessContent_whenCreate_thenThrowException() {

        // given
        String content = "abc";

        // when, then
        assertThrows(IllegalArgumentException.class, ()-> new PostContent(content));

    }

    @Test
    public void givenOverContent_whenCreate_thenThrowException() {

        // given
        String content = "a".repeat(501);

        // when, then
        assertThrows(IllegalArgumentException.class, ()-> new PostContent(content));

    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 슭, 걃"})
    public void givenOverContentWithSpecialWord_whenCreate_thenThrowException(String korean) {

        // given
        String content = korean.repeat(501);

        // when, then
        assertThrows(IllegalArgumentException.class, ()-> new PostContent(content));

    }



    @Test
    public void givenEnoughContent_whenCreate_thenSuccess() {

        // given
        String content = "abcde";

        // when, then
        PostContent postContent = new PostContent(content);

        String result = postContent.getContentText();

        Assertions.assertEquals(content, result);

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void givenNullOrBlank_whenCreate_thenThrowException(String value) {

        // when, then
        assertThrows(IllegalArgumentException.class, ()-> new PostContent(value));

    }

}
