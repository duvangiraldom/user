package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.domain.gateway.IParameterRepository;
import com.nisum.user.in_memory_repository.entities.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ParameterRepository implements IParameterRepository {

    @Autowired
    private IParameterDataRepository repository;

    @Override
    public com.nisum.user.domain.models.Parameter findParameterByKey(String key) {
        Parameter entity = repository.findFirstByKeyIgnoreCase(key);
        return com.nisum.user.domain.models.Parameter.builder()
                .key(entity.getKey())
                .value(entity.getValue())
                .build();
    }

    @Override
    public Map<String, String> updateParameter(com.nisum.user.domain.models.Parameter parameter) {
        saveOrUpdateParameter(parameter);
        Map<String, String> message = new HashMap<>();
        message.put("message", String.format("Parameter %s has been saved or updated successfully", parameter.getKey()));
        return message;
    }

    private void saveOrUpdateParameter(com.nisum.user.domain.models.Parameter model) {
        Parameter parameterEntity = repository.findFirstByKeyIgnoreCase(model.getKey());
        if (parameterEntity != null) {
            repository.updateParameter(parameterEntity.getId(), model.getValue());
        } else {
            repository.save(Parameter.builder()
                    .key(model.getKey())
                    .value(model.getValue())
                    .build());
        }

    }
}
