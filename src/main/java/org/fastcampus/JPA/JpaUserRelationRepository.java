package org.fastcampus.JPA;

import org.fastcampus.user.model.UserRelationEntity;
import org.fastcampus.user.model.UserRelationIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {
}
