package com.nilportugues.simplewebapi.domain.model.attributes;

public class UserId {
    String userId;

    public UserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String toString() {
        return userId;
    }
}