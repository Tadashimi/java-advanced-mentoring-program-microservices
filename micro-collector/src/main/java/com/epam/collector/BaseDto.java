package com.epam.collector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class BaseDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String username;

    @Column
    String message;

    protected BaseDto() {}

    public BaseDto(long id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    public BaseDto(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
