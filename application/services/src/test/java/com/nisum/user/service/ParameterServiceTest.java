package com.nisum.user.service;

import com.nisum.user.domain.gateway.IParameterRepository;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParameterServiceTest {

    private static final String TEST = "TEST";

    @InjectMocks
    private ParameterService service;

    @Mock
    private IParameterRepository parameterRepository;

    private Parameter parameter;

    @Before
    public void setUp() {
        parameter = Parameter.builder()
                .key(TEST)
                .value("^[0-9]*)$")
                .build();
    }

    @Test
    public void shouldUpdateParameter() {
        Map<String, String> message = new HashMap<>();
        message.put("message", String.format("Parameter %s has been saved or updated successfully", parameter.getKey()));
        when(parameterRepository.updateParameter(any(Parameter.class))).thenReturn(message);
        Map<String, String> current = service.updateParameter(parameter);
        assertThat(current).isEqualTo(message);
    }

}
