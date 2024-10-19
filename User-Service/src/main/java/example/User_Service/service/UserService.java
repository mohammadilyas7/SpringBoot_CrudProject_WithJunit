package example.User_Service.service;

import example.User_Service.model.User;
import example.User_Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String register(User user){
        userRepository.save(user);
        return "User Successfully Register";
    }

    public User getUserDetails(String email) {
        User user = userRepository.findById(email).get();
        System.out.println();
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteUser(String id) {
       userRepository.deleteById(id);
       return "User Delete";
    }
}