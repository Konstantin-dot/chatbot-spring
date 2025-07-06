package com.example.chatbot.service;

import com.example.chatbot.dto.MessageDto;
import com.example.chatbot.entity.MessageEntity;
import com.example.chatbot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Primary
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;


    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            timeout = 10000,
            readOnly = true
    )
    @Override
    @Cacheable(value = "messages", key = "#id")
    public MessageDto findById(Long id) throws Exception {
        if (Objects.isNull(id)) throw new Exception("id can not be null");
        return messageRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    @Override
    public List<MessageDto> findAll() {
        List<MessageEntity> list = messageRepository.findAll();
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto create(MessageDto dto) {
        MessageEntity entity = this.mapToEntity(dto);
        entity=  messageRepository.save(entity);
        return this.mapToDto(entity);
    }

    @Transactional(
            isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED
    )
    @Override
    @CacheEvict(value = "messages", key = "#dto.id")
    public MessageDto update(MessageDto dto) throws Exception {
        Optional<MessageEntity> originalEntity = messageRepository.findById(dto.getId());
        if (originalEntity.isPresent()) {
            MessageEntity entity = this.mapToEntity(dto);
            entity=  messageRepository.save(entity);
            return this.mapToDto(entity);
        }else{
            throw new Exception("entity not found");
        }

    }
    @Transactional(
            isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED
    )
    @Override
    public void delete(Long id) {
        MessageEntity entity = messageRepository.findById(id)
                .orElseThrow();
        messageRepository.delete(entity);
    }



    public MessageDto mapToDto(MessageEntity entity) {
        return new MessageDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getPatronymic(), entity.getBirthDate(), entity.getMessage());
    }

    public MessageEntity mapToEntity(MessageDto dto) {
        return new MessageEntity(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getPatronymic(), dto.getBirthDate(), dto.getMessage());
    }
}
