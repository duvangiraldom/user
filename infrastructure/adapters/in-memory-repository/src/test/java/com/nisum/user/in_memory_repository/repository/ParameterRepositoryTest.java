package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.domain.models.Parameter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParameterRepositoryTest {

    private static final String TEST = "TEST";

    @InjectMocks
    private ParameterRepository repository;

    @Mock
    private IParameterDataRepository dataRepository;

    private Parameter parameter;
    private com.nisum.user.in_memory_repository.entities.Parameter parameterEntity;

    @Before
    public void setUp() {
        parameter = Parameter.builder()
                .key(TEST)
                .value("^[0-9]*)$")
                .build();
        parameterEntity = com.nisum.user.in_memory_repository.entities.Parameter.builder()
                .key(TEST)
                .value("^[0-9]*)$")
                .build();
    }

    @Test
    public void shouldFindParameterByKey() {
        when(dataRepository.findFirstByKeyIgnoreCase(anyString())).thenReturn(parameterEntity);
        Parameter current = repository.findParameterByKey(TEST);
        assertThat(current).isEqualTo(parameter);
    }

    @Test
    public void shouldUpdateParameter() {
        Map<String, String> message = new HashMap<>();
        message.put("message", String.format("Parameter %s has been saved or updated successfully", parameter.getKey()));
        when(dataRepository.findFirstByKeyIgnoreCase(anyString())).thenReturn(parameterEntity);
        Map<String, String> current = repository.updateParameter(parameter);
        assertThat(current).isEqualTo(message);
    }

    @Test
    public void shouldSaveParameter() {
        Map<String, String> message = new HashMap<>();
        message.put("message", String.format("Parameter %s has been saved or updated successfully", parameter.getKey()));
        when(dataRepository.findFirstByKeyIgnoreCase(anyString())).thenReturn(null);
        when(dataRepository.save(any(com.nisum.user.in_memory_repository.entities.Parameter.class))).thenReturn(parameterEntity);
        Map<String, String> current = repository.updateParameter(parameter);
        assertThat(current).isEqualTo(message);
    }
}
