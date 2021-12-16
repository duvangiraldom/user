package com.nisum.user.domain.gateway;

import com.nisum.user.domain.models.Parameter;

import java.util.Map;

public interface IParameterRepository {

    Map<String, String> updateParameter(Parameter parameter);
}
