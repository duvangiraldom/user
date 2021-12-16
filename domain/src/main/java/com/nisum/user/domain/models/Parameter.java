package com.nisum.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Parameter {

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    private String key;

    @NotEmpty(message = "Field should not be empty")
    @NotNull(message = "Field is required")
    private String value;
}
