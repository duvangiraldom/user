package com.nisum.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private String number;

    private String cityCode;

    private String countryCode;

}
