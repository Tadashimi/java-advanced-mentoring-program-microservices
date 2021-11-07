package com.epam.recipient;

public class BaseDto {
    String username;
    String message;

    protected BaseDto() {}

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
