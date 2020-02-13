package com.tntu.service;

import com.tntu.entity.Message;
import com.tntu.entity.User;

import java.io.IOException;

public interface MessageService {

    Message addMessage(Message message);

    Iterable<Message> getAllMessages();

    Message updateMessage(Long messageId, String text, User user) throws IOException;

    Message getMessage(long id) throws IOException;

    void deleteMessage(Long id, User user);

}
