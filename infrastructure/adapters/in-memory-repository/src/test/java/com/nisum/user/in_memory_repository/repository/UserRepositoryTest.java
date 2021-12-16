package com.nisum.user.in_memory_repository.repository;

import com.nisum.user.domain.gateway.IUserRepository;
import com.nisum.user.domain.models.Parameter;
import com.nisum.user.domain.models.Phone;
import com.nisum.user.domain.models.User;
import com.nisum.user.in_memory_repository.mapper.ParserEntityToModel;
import com.nisum.user.in_memory_repository.mapper.ParserModelToEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    private static final String TEST = "TEST";
    private static final Integer TEST_NUM = 1;
    private static final UUID TEST_UUID = UUID.randomUUID();
    private static final LocalDateTime TEST_DATE = LocalDateTime.now();

    @InjectMocks
    private UserRepository repository;

    @Mock
    private ParserModelToEntity parserModelToEntity;

    @Mock
    private ParserEntityToModel parserEntityToModel;

    @Mock
    private IUserDataRepository userDataRepository;

    private User user;
    private com.nisum.user.in_memory_repository.entities.User userEntity;

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

        userEntity = com.nisum.user.in_memory_repository.entities.User.builder()
                .name(TEST)
                .email(TEST)
                .password(TEST)
                .phones(List.of(com.nisum.user.in_memory_repository.entities.Phone.builder()
                        .id(TEST_UUID)
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
    }

    @Test
    public void shouldSaveUser() {
        when(parserModelToEntity.mapToEntity(any(User.class))).thenReturn(userEntity);
        when(parserEntityToModel.mapToModel(any(com.nisum.user.in_memory_repository.entities.User.class))).thenReturn(user);
        when(userDataRepository.save(any(com.nisum.user.in_memory_repository.entities.User.class))).thenReturn(userEntity);
        User current = repository.saveUser(user);
        verify(parserModelToEntity, times(1)).mapToEntity(any(User.class));
        verify(parserEntityToModel, times(1)).mapToModel(any(com.nisum.user.in_memory_repository.entities.User.class));
        verify(userDataRepository, times(1)).save(any(com.nisum.user.in_memory_repository.entities.User.class));
        assertThat(current).isNotNull();
    }
}
