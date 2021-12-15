package com.nisum.user.in_memory_repository.mapper;

import com.nisum.user.in_memory_repository.entities.Phone;
import com.nisum.user.in_memory_repository.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParserModelToEntity {

    public User mapToEntity(com.nisum.user.domain.models.User user) {
        try {
            return User.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .created(LocalDateTime.now())
                    .modified(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .token(UUID.randomUUID())
                    .isActive(true)
                    .phones(mapToEntity(user.getPhones()))
                    .build();

        } catch (Exception ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }

    private List<Phone> mapToEntity(List<com.nisum.user.domain.models.Phone> phones) {
        return phones.stream().map(phone -> Phone.builder()
                        .number(phone.getNumber())
                        .cityCode(phone.getCityCode())
                        .countryCode(phone.getCountryCode())
                        .build())
                .collect(Collectors.toList());
    }
}
