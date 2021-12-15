package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private IUserDataRepository repository;

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public String saveUser(User user) {


        return null;
    }
}
