package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.common.domain.PositiveIntegerCounter;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followerCount;
    private final PositiveIntegerCounter followingCount;

    public User(Long id, UserInfo userInfo, PositiveIntegerCounter followerCount,
            PositiveIntegerCounter followingCount) {
        this.id = id;
        this.userInfo = userInfo;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
    }
    // 팔로우
    // A -> B 를 팔로우
    // A의 팔로잉 증가
    // B의 팔로워 증가
    public void follow(User targetUser){
        if(this.equals(targetUser))
        {
            throw new IllegalArgumentException("Error");
        }
        followingCount.increaseCount();
        targetUser.increaseFollowerCount();
    }

    // 언팔로우
    // A -> B 를 언팔로우
    // A의 팔로잉 감소
    // B의 팔로워 감소
    public void unfollow(User targetUser){
        if(this.equals(targetUser))
        {
            throw new IllegalArgumentException("Error");
        }
        followingCount.decreaseCount();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followingCount.increaseCount();
    }

    private void decreaseFollowerCount(){
        followerCount.decreaseCount();
    }

    // Override를 통해 객체 간 비교시 메모리 주소값이 아닌 객체간 비교를 할 수 있게 수정
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userInfo,
                user.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userInfo);
    }

}
