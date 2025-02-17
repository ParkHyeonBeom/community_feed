package org.fastcampus.user.domain;

// VO 객체를 활용하여 유효성 검증 진행
public class UserInfo {

    private final String name;
    private final String profileImageUrl;

    public UserInfo(String name, String profileImageUrl) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        this.name = name;
        this.profileImageUrl = profileImageUrl;

    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getName() {
        return name;
    }
}
