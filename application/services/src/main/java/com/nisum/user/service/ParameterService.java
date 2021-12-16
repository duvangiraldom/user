package com.nisum.user.service;

import com.nisum.user.domain.gateway.IParameterRepository;
import com.nisum.user.domain.models.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ParameterService implements IParameterService {

    @Autowired
    private IParameterRepository parameterRepository;

    @Override
    public Map<String, String> updateParameter(Parameter parameter) {
        return parameterRepository.updateParameter(parameter);
    }

}
