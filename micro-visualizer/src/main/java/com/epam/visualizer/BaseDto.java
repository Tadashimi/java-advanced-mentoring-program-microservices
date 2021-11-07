package com.epam.visualizer;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("username")
    String username;

    @Column
    @JsonProperty("message")
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
