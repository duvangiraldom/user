package com.nisum.user.domain.gateway;

import com.nisum.user.domain.models.User;

public interface IUserRepository {

    User saveUser(User user);

    Boolean existsUserByEmail(String email);

    User getUserByEmail(String email);
}
