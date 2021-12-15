package com.nisum.user.service;

import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public String saveUser(User user) {
        return null;
    }

}
