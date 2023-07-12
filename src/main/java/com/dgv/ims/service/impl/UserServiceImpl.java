package com.dgv.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.ims.entity.User;
import com.dgv.ims.exception.ResourceNotFoundException;

import com.dgv.ims.repository.UserRepository;
import com.dgv.ims.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Check if user exists
        User existingUser = userRepo.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Update the user properties
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());

        return userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        // Check if user exists
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userRepo.delete(existingUser);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
