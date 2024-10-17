package example.User_Service.controller;

import example.User_Service.model.User;
import example.User_Service.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");

        when(userService.register(any(User.class))).thenReturn(String.valueOf(user));

        ResponseEntity<?> response = userController.register(user);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testGetUserDetails(){
        User user =new User();
        user.setEmail("ilyas78874@gmail.com");
        user.setName("Test User");

        when(userService.getUserDetails(anyString())).thenReturn(user);

        ResponseEntity<?> response = userController.getUserDetails(user.getEmail());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(user,response.getBody());
    }
    @Test
    public void testGetAllUsers(){
        List<User> userList = new ArrayList<>();
        userList.add(new User());

        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<?> response = userController.getAllUsers();
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(userList,response.getBody());
    }
}