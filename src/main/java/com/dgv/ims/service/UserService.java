package com.dgv.ims.service;

import java.util.List;

import com.dgv.ims.entity.User;

public interface UserService {
	
	User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();

}
