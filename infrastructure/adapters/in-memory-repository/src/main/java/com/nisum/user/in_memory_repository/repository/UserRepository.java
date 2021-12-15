package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.in_memory_repository.entities.User;
import com.nisum.user.in_memory_repository.mapper.ParserModelToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private ParserModelToEntity parserModelToEntity;

    @Autowired
    private IUserDataRepository repository;

    @Override
    public com.nisum.user.domain.models.User getUserById() {
        return null;
    }

    @Override
    public String saveUser(com.nisum.user.domain.models.User user) {
        User entity = parserModelToEntity.mapToEntity(user);
        User u = repository.save(entity);
        return "HI";
    }
}
