package com.botwy.erp.controller;


import com.botwy.erp.entity.ChatMessage;
import com.botwy.erp.entity.IChatMessage;
import com.botwy.erp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3333"}, maxAge = 6000, allowCredentials = "false")
@RestController
public class ChatRestController {

    private ChatMessageRepository repository;

    @Autowired
    public ChatRestController(ChatMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "login")
    public List login(@RequestParam("name") String name) {
        String msgText = "К чату присоединился "+ name;
      //  model.addAttribute("message", responce);
        repository.save(new ChatMessage(name, msgText));
        List list = new ArrayList();
        list.add("true");
        return list;

    }

    @RequestMapping(path = "/allchats", method = RequestMethod.GET, headers="Accept=application/json")
    public List<ChatMessage> getAllMsg() {

        return  (List<ChatMessage>) repository.findAll();
    }

    @GetMapping(path = "/chat/{id}", headers="Accept=application/json")
    public IChatMessage getMsgById(@PathVariable long id) {
        return (ChatMessage)repository.findOne(id);
    }

}
