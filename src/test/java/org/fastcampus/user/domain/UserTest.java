package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {

    // given
    private final UserInfo userInfo = new UserInfo("abc", "");
    private final User user1 = new User(1L,userInfo);
    private final User user2 = new User(2L, userInfo);

    @Test
    void givenTwoUsers_whenEquals_thenFalse() {

        // when
        boolean value = user1.equals(user2);

        // then
        assertFalse(value);

    }

    @Test
    void givenSameUsers_whenEquals_thenTrue() {

        // when
        boolean value = user1.equals(user1);

        // then
        assertTrue(value);

    }

    @Test
    void givenTwoUsers_whenHashCode_thenFalse() {

        //when
        boolean value = user1.hashCode() == user2.hashCode();

        //then
        assertFalse(value);
    }

    @Test
    void givenSameUsers_whenHashCode_thenTrue() {

        //when
        boolean value = user1.hashCode() == user1.hashCode();

        //then
        assertTrue(value);
    }

    @Test
    void givenTwoUsers_whenUser1FollowUser2_thenUser2FollowerCountIs1(){

        //when
        user1.follow(user2);
        //then
        assertEquals(1,user2.getFollowerCount().getCount());

    }

    @Test
    void givenSameUsers_whenFollow_thenThrowException(){

    }
}
