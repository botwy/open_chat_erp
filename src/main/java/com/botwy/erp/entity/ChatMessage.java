package com.botwy.erp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChatMessage implements IChatMessage{

    @Id
    @GeneratedValue
    private Long id;

    private String senderName;

    private String msgText;


    public ChatMessage() {
    }

    public ChatMessage(String senderName, String msgText) {
        this.senderName = senderName;
        this.msgText = msgText;
    }

    public Long getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", msgText='" + msgText + '\'' +
                '}';
    }
}
