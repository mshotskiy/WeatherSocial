package com.tntu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String text;

    private String userName;

    public Message() {
    }

    public Message(String text, String userName) {
        this.text = text;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                Objects.equals(text, message.text) &&
                Objects.equals(userName, message.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, userName);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
