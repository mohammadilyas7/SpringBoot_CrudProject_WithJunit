package example.User_Service.controller;

import example.User_Service.model.User;
import example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserService/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> register(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @GetMapping("/UserDetails/{email}")
    public ResponseEntity<?> getUserDetails(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserDetails(email),HttpStatus.OK);
    }

    @GetMapping("/disPlayAllUser")
    public ResponseEntity<?> disPlayAllUser(){
        return new ResponseEntity<>(userService.disPlayAllUser(),HttpStatus.OK);
    }

    @PutMapping("/updateMobile/{email}/{number}")
    public ResponseEntity<?> updateMobile(@PathVariable String email,@PathVariable long number){
        return new ResponseEntity<>(userService.updateMobile(email,number),HttpStatus.CREATED);
    }
}