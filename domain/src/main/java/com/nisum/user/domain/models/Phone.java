package com.nisum.user.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @NotEmpty
    @NotEmpty(message = "Field is required")
    private String number;

    @JsonProperty("citycode")
    @NotEmpty
    @NotEmpty(message = "Field is required")
    private String cityCode;

    @JsonProperty("contrycode")
    @NotEmpty
    @NotEmpty(message = "Field is required")
    private String countryCode;

}
