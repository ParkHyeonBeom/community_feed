package org.fastcampus.user.domain;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.fastcampus.common.domain.PositiveIntegerCounter;

@Builder
@AllArgsConstructor
@Getter
public class User {

    private Long id;
    private UserInfo userInfo;
    private PositiveIntegerCounter followerCount;
    private PositiveIntegerCounter followingCount;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.userInfo = userInfo;
        this.followerCount = new PositiveIntegerCounter();
        this.followingCount = new PositiveIntegerCounter();
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
        followerCount.increaseCount();
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
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userInfo);
    }

    public int getFollowerCount() {
        return followerCount.getCount();
    }

    public int getFollowingCount( ) {
        return followingCount.getCount();
    }

    public String getProfileImage() {
        return userInfo.getProfileImageUrl();
    }
    public String getName() {
        return userInfo.getName();
    }

}
