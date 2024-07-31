package com.greenhaat.security_client.controller;

import com.greenhaat.security_client.entity.User;
import com.greenhaat.security_client.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/profile")
    public ResponseEntity<Optional<User>> profile(Principal principal) {
        String username = principal.getName();
        Optional<User> user = userDetailsService.findByUsername(username);
        if (user.isPresent()) {
            System.out.println(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
//    @PostMapping("/profile")
//    public ResponseEntity<User> profilePost(@RequestBody User newUser) {
//        try {
//            User updatedUser =userDetailsService.updateUser(newUser.getUsername(), newUser);
//            System.out.println(updatedUser + "sucess");
////            User updatedUser = userService.updateUser( newUser);
//            return ResponseEntity.ok(updatedUser);
//        } catch (UsernameNotFoundException e) {
//            System.out.println(newUser+ "failed");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
}
