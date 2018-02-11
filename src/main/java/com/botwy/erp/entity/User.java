package com.botwy.erp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements IUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private boolean exitFromChat;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean exitFromChat) {
        this.name = name;
        this.exitFromChat = exitFromChat;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isExitFromChat() {
        return exitFromChat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExitFromChat(boolean exitFromChat) {
        this.exitFromChat = exitFromChat;
    }
}
