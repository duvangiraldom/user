package com.nisum.user.in_memory_repository.mapper;

import com.nisum.user.in_memory_repository.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParserModelToEntity {

    public User mapToEntity(com.nisum.user.domain.models.User user) {
        try {
            return User.builder()

                    .build();

        } catch (Exception ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }
}
