package com.nisum.user.web_service.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserFilterDto {

    @NotEmpty(message = "Field is required")
    @NotNull(message = "Field is required")
    private String email;
}
