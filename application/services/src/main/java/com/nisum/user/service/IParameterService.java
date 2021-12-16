package com.nisum.user.service;

import com.nisum.user.domain.models.Parameter;

import java.util.Map;

public interface IParameterService {

    Map<String, String> updateParameter(Parameter parameter);

}
