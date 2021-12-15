package com.nisum.user.domain.gateway;

import com.nisum.user.domain.models.User;

public interface IUserRepository {

    User getUserById();

    String saveUser(User user);
}