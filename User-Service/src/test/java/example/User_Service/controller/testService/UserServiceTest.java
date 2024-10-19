package example.User_Service.controller.testService;

import example.User_Service.model.User;
import example.User_Service.repository.UserRepository;
import example.User_Service.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

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

        // Mock the userRepository to simulate saving the user
        when(userRepository.findById(user.getEmail())).thenReturn(Optional.empty()); // No existing user
        String result = userService.register(user);

        assertEquals("User Successfully Register", result);
//        verify(userRepository, times(1)).save(user); // Verify that save was called
    }
}