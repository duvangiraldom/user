package com.nisum.user.service;

import com.nisum.user.domain.exceptions.BusinessException;
import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user) {

        if (!existsUserByEmail(user.getEmail())) {
            return userRepository.saveUser(user);
        }

        throw new BusinessException("The email is already registered");
    }

    @Override
    public User getUserByEmail(String email) {

        if (existsUserByEmail(email)) {
            return userRepository.getUserByEmail(email);
        }

        throw new BusinessException("The email is not registered");
    }

    private Boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

}
