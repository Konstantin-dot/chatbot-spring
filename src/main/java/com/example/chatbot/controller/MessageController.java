package com.example.chatbot.controller;

import com.example.chatbot.dto.MessageDto;
import com.example.chatbot.service.MessageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/api/chatbot-spring/Message/{id}", produces = "application/json")
    public MessageDto findById(@PathVariable Long id) throws Exception {
        return messageService.findById(id);
    }


    @GetMapping("/api/chatbot-spring/Messages")
    public List<MessageDto> findAll() {
        return messageService.findAll();
    }

    @PostMapping("/api/chatbot-spring/Message")
    public MessageDto create(@RequestBody MessageDto dto) {
        return messageService.create(dto);
    }

    @PutMapping("/api/chatbot-spring/Message/{id}")
    public MessageDto update(@PathVariable Long id, @RequestBody MessageDto dto) throws Exception {
        return messageService.update(dto);
    }

    @DeleteMapping("/api/chatbot-spring/Message/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
