package com.nisum.user.in_memory_repository.mapper;

import com.nisum.user.domain.models.Phone;
import com.nisum.user.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParserEntityToModel {

    public User mapToModel(com.nisum.user.in_memory_repository.entities.User user) {
        try {
            return User.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .id(user.getId())
                    .created(user.getCreated())
                    .modified(user.getModified())
                    .lastLogin(user.getLastLogin())
                    .token(user.getToken())
                    .isActive(user.getIsActive())
                    .phones(mapToModel(user.getPhones()))
                    .build();

        } catch (Exception ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }

    private List<Phone> mapToModel(List<com.nisum.user.in_memory_repository.entities.Phone> phones) {
        return phones.stream().map(phone -> Phone.builder()
                        .number(phone.getNumber())
                        .cityCode(phone.getCityCode())
                        .countryCode(phone.getCountryCode())
                        .build())
                .collect(Collectors.toList());
    }
}
