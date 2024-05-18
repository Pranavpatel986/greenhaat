package com.greenHat.springsecurityclient.services.serviceImpl;

import com.greenHat.springsecurityclient.entities.User;
import com.greenHat.springsecurityclient.entities.VerificationToken;
import com.greenHat.springsecurityclient.models.UserModel;
import com.greenHat.springsecurityclient.repositories.UserRepository;
import com.greenHat.springsecurityclient.repositories.VerificationTokenRepository;
import com.greenHat.springsecurityclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {
        User user=new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken=new VerificationToken(user,token);
        verificationTokenRepository.save(verificationToken);
    }
}
