package project2.reviewapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;
    private User user;

    @BeforeEach
    public void init(){
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
        user = User.builder()
                .id(1)
                .email("java@gmail.com")
                .firstname("Ja")
                .lastname("Va")
                .username("java")
                .password("pass123")
                .build();
    }

    @Test
    public void getAllUsersList(){
        List<User> userList = new ArrayList<>();
        userList.add(user);

        when(userService.getAllUsers()).thenReturn(userList);
        List<User> userList1 = userService.getAllUsers();

        assertThat(userList1).isNotNull();
        assertThat(userList1.size()).isEqualTo(1);
    }

    @Test
    public void getUserById(){
        when(userService.getUserById(1)).thenReturn(Optional.ofNullable(user));
        Optional<User> users = userService.getUserById(1);

        assertThat(users).isNotNull();
        assertThat(users.get().getId()).isEqualTo(1);
    }
}