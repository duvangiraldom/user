package com.nisum.user.service;

import com.nisum.user.domain.models.User;

public interface IUserService {

    User saveUser(User user);

    User getUserByEmail(String email);
}
