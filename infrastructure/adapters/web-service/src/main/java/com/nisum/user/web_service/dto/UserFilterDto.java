package com.nisum.user.web_service.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserFilterDto {

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    @Email(message = "Field format should be username@domain.com")
    @Pattern(regexp = "^(.+)@(\\S+).(\\S+)$", message = "Field format should be username@domain.subdomain")
    private String email;
}
