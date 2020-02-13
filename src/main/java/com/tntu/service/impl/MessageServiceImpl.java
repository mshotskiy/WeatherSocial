package com.tntu.service.impl;

import com.tntu.entity.Message;
import com.tntu.entity.User;
import com.tntu.repository.MessageRepository;
import com.tntu.service.MessageService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id, User user){
        Message message = null;
        try {
            message = getMessage(id);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (message.getUserName().equals(user.getUsername())){
            messageRepository.delete(message);
        }
    }

    @Override
    public Message updateMessage(Long messageId, String text, User user) throws IOException {
        Message message = getMessage(messageId);

        if (message.getUserName().equals(user.getUsername())){
            message.setText(text);
            messageRepository.save(message);
            return message;
        }else {
            throw new IOException();
        }
    }

    @Override
    public Message getMessage(long id) throws IOException {
        return messageRepository.findById(id).orElseThrow(IOException::new);
    }

    @Override
    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
