package com.example.chatbot.client;

import com.example.chatbot.dto.UserResponseDto;
import feign.RequestLine;

public interface UserClient {

    @RequestLine("GET /api")
    UserResponseDto findAll();



}
