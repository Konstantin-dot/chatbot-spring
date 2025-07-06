package com.example.chatbot.service;


import com.example.chatbot.dto.MessageDto;

import java.util.List;

public interface MessageService {

    MessageDto findById(Long id) throws Exception;

    List<MessageDto> findAll();

    MessageDto create(MessageDto dto);


    MessageDto update(MessageDto dto) throws Exception;


    void delete(Long id);

}
