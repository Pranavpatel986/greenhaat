package com.greenHat.springsecurityclient.services;

import com.greenHat.springsecurityclient.entities.User;
import com.greenHat.springsecurityclient.models.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
