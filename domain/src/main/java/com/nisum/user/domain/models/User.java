package com.nisum.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotEmpty
    @NotNull(message = "Field is required")
    private String name;

    @NotEmpty
    @NotNull(message = "Field is required")
    @Email(message = "Field format should be username@domain.com")
    @Pattern(regexp = "^(.+)@(\\S+).(\\S+)$", message = "Field format should be username@domain.subdomain")
    private String email;

    @NotEmpty
    @NotNull(message = "Field is required")
    private String password;

    @NotNull(message = "Field is required")
    @NotEmpty(message = "List of answers are required")
    private List<@Valid Phone> phones;

}
