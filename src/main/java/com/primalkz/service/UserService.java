package com.primalkz.service;

import com.primalkz.exception.UserException;
import com.primalkz.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

}
