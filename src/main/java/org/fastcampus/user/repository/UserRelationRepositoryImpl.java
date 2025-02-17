package org.fastcampus.user.repository;

import java.util.HashSet;
import java.util.Set;
import javax.management.relation.Relation;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.interfaces.UserRelationRepository;

public class UserRelationRepositoryImpl implements UserRelationRepository {

    @Override
    public boolean isAlreadyFollow(User user, User targetUser) {
        return false;
    }

    @Override
    public void save(User user, User targetUser) {

    }

    @Override
    public void delete(User user, User targetUser) {

    }

}
