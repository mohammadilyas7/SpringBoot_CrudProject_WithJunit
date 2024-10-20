package example.User_Service.testService;

import example.User_Service.model.User;
import example.User_Service.repository.UserRepository;
import example.User_Service.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testRegister(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setName("Test User");

        when(userRepository.findById(user.getEmail())).thenReturn(Optional.empty()); // No existing user
        String result = userService.register(user);

        assertEquals("User Successfully Register", result);
    }
    @Test
    public void testGetUserDetails(){
        String email = "ilyas78874@gmail.com";
        User user = new User();
        user.setEmail(email);
        user.setName("Test User");
        // Mock the repository to return an existing user
        when(userRepository.findById(email)).thenReturn(Optional.of(user));

        User result = userService.getUserDetails(email);

        assertNotNull(result);
        assertEquals("Test User", result.getName());
        assertEquals(email, result.getEmail());
    }
    @Test
    public void testGetAllUsers(){
        when(userRepository.findAll()).thenReturn(List.of());

        List<User> result = userService.getAllUsers();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}