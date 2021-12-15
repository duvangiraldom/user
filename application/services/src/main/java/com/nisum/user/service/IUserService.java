package com.nisum.user.service;

import com.nisum.user.domain.models.User;

public interface IUserService {

    User getUserById();

    String saveUser(User user);
}
