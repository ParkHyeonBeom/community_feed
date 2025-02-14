package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void givenNameAndProfileUrl_whenCreated_thenThrowNothing() {
        //given
        String name = "abc";
        String profileUrl = "";

        //when
        //then
        Assertions.assertDoesNotThrow(()-> new UserInfo(name, profileUrl));
    }

    @Test
    void givenBlankNameAndProfileUrl_whenCreated_thenThrowException() {
        //given
        String name = "";
        String profileUrl = "";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileUrl));
    }

}
