package com.nisum.user.service;

import com.nisum.user.domain.exceptions.BusinessException;
import com.nisum.user.domain.gateway.IParameterRepository;
import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.Parameter;
import com.nisum.user.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {

    private static String KEY_PASSWORD_REGEX = "PASSWORD-REGEX";

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IParameterRepository parameterRepository;

    @Override
    public User saveUser(User user) {

        if (!isValidPasswordRegex(user.getPassword())) {
            throw new BusinessException("The password format is not valid");
        }

        if (existsUserByEmail(user.getEmail())) {
            throw new BusinessException("The email is already registered");
        }

        return userRepository.saveUser(user);
    }

    private Boolean isValidPasswordRegex(String password) {
        try {
            Parameter passwordRegexParameter = parameterRepository.findParameterByKey(KEY_PASSWORD_REGEX);
            if (passwordRegexParameter != null && !passwordRegexParameter.getValue().isEmpty()) {
                return Pattern.matches(passwordRegexParameter.getValue(), password);
            }
            return true;
        } catch (Exception exception) {
            return true;
        }
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
