package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        // when
        boolean value = user1.hashCode() == user2.hashCode();

        // then
        assertFalse(value);
    }

    @Test
    void givenSameUsers_whenHashCode_thenTrue() {

        // when
        boolean value = user1.hashCode() == user1.hashCode();

        // then
        assertTrue(value);
    }

    @Test
    void givenTwoUsers_whenUser1FollowUser2_thenIncreaseUserCount() {

        // when
        user1.follow(user2);
        // then
        assertEquals(1,user2.getFollowerCount());
        assertEquals(1,user1.getFollowingCount());
        assertEquals(0,user2.getFollowingCount());
        assertEquals(0,user1.getFollowerCount());

    }

    @Test
    void givenTwoUsersFollow_whenUser1UnFollowUser2_thenDecreaseUserCount() {

        // given
        user1.follow(user2);

        // when
        user1.unfollow(user2);

        // then
        assertEquals(0,user1.getFollowerCount());
        assertEquals(0,user2.getFollowerCount());
        assertEquals(0,user1.getFollowingCount());
        assertEquals(0,user2.getFollowingCount());

    }

    @Test
    void givenTwoUsers_whenUser1UnFollowUser2_then0() {

        // when
        user1.unfollow(user2);

        // then
        assertEquals(0,user1.getFollowerCount());
        assertEquals(0,user2.getFollowerCount());
        assertEquals(0,user1.getFollowingCount());
        assertEquals(0,user2.getFollowingCount());

    }




}
