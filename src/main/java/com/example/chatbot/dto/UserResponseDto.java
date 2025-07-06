package com.example.chatbot.dto;

import java.util.List;

public class UserResponseDto {
    private List<UserDto> results;

    public UserResponseDto() {
    }

    public UserResponseDto(List<UserDto> results) {
        this.results = results;
    }

    public List<UserDto> getResults() {
        return results;
    }

    public void setResults(List<UserDto> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "results=" + results +
                '}';
    }
}
