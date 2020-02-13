package com.tntu.repository;

import com.tntu.entity.Message;
import com.tntu.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
