package com.example.chatbot.service;

import com.example.chatbot.client.UserClient;
import com.example.chatbot.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserResponseDto findAll() {
        return userClient.findAll();
    }
}
