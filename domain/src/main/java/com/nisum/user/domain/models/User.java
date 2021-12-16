package com.nisum.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    private String name;

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    @Email(message = "Field format should be username@domain.com")
    @Pattern(regexp = "^(.+)@(\\S+).(\\S+)$", message = "Field format should be username@domain.subdomain")
    private String email;

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    private String password;

    @NotNull(message = "Field is required")
    @NotEmpty(message = "List of phones should not be empty")
    private List<@Valid Phone> phones;

    private UUID id;

    private LocalDateTime created;

    private LocalDateTime modified;

    private LocalDateTime lastLogin;

    private UUID token;

    private Boolean isActive;

}
