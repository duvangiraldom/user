package com.nisum.user.service;

import com.nisum.user.domain.gateway.IParameterRepository;
import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.Parameter;
import com.nisum.user.domain.models.Phone;
import com.nisum.user.domain.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final String TEST = "TEST";
    private static final Integer TEST_NUM = 1;
    private static final UUID TEST_UUID = UUID.randomUUID();
    private static final LocalDateTime TEST_DATE = LocalDateTime.now();

    @InjectMocks
    private UserService service;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IParameterRepository parameterRepository;

    private User user;
    private Parameter passwordRegexParameter;

    @Before
    public void setUp() {
        user = User.builder()
                .name(TEST)
                .email(TEST)
                .password(TEST)
                .phones(List.of(Phone.builder()
                        .number(TEST)
                        .cityCode(TEST)
                        .countryCode(TEST)
                        .build()))
                .id(TEST_UUID)
                .created(TEST_DATE)
                .modified(TEST_DATE)
                .lastLogin(TEST_DATE)
                .token(TEST_UUID)
                .isActive(Boolean.TRUE)
                .build();

        passwordRegexParameter = Parameter.builder()
                .build();
    }

    @Test
    public void shouldSaveUser() {
        when(parameterRepository.findParameterByKey(anyString())).thenReturn(passwordRegexParameter);
        when(userRepository.existsUserByEmail(anyString())).thenReturn(false);
        when(userRepository.saveUser(any(User.class))).thenReturn(user);
        User current = service.saveUser(user);
        verify(parameterRepository, times(1)).findParameterByKey(anyString());
        verify(userRepository, times(1)).existsUserByEmail(anyString());
        verify(userRepository, times(1)).saveUser(any(User.class));
        assertThat(current).isNotNull();
    }

}
