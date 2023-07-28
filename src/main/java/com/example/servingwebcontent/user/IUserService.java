package com.example.servingwebcontent.user;

import com.example.servingwebcontent.registration.RegistrationRequest;
import com.example.servingwebcontent.registration.token.VerificationToken;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    String validateToken(String theToken);
}
