package com.botwy.erp.controller;


import com.botwy.erp.entity.ChatMessage;
import com.botwy.erp.entity.IChatMessage;
import com.botwy.erp.entity.User;
import com.botwy.erp.repository.ChatMessageRepository;
import com.botwy.erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//? For JSON ответа: @RestController (with headers="Accept=application/json") или @Controller and @ResponseBody ?
@CrossOrigin(origins = {"http://localhost:3333"}, maxAge = 6000, allowCredentials = "false")
@RestController
@RequestMapping("/chat")
public class ChatRestController {

    private ChatMessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public ChatRestController(ChatMessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    //? завасисмость от ChatMessage и User как ослабить?
    @GetMapping("/login")
    public boolean login(@RequestParam("name") String name) {
        if (userRepository.findByName(name).size()>0)
            return false;

        User user = new User(name,false);
        userRepository.save(user);

        String msgText = "К чату присоединился "+ name;
        messageRepository.save(new ChatMessage(name, msgText));
        return true;
    }

    //? завасисмость от ChatMessage как ослабить?
    @PostMapping("/new_msg")
   // public boolean newMsg(@RequestParam("name") String name,@RequestParam("msg") String msgText) {
    public boolean newMsg(@RequestBody ChatMessage msg) {
        checkMsg(msg);
        messageRepository.save(msg);
        return true;
    }

    @GetMapping(path = "/allchats", headers="Accept=application/json")
    public List<? extends IChatMessage> getAllMsg() { return  (List<ChatMessage>) messageRepository.findAll(); }

    @GetMapping(path = "/{id}", headers="Accept=application/json")
    public IChatMessage getMsgById(@PathVariable long id) {
        return (ChatMessage) messageRepository.findOne(id);
    }

    @GetMapping("/exit")
    public boolean exitChat(@RequestParam("name") String name) {
        List<User> userList = userRepository.findByName(name);
        if (userList.size()==0) return false;
        User user = userList.get(0);
        user.setExitFromChat(true);
        userRepository.save(user);

        String msgText = "Чат покинул "+ name;
        messageRepository.save(new ChatMessage(name, msgText));
        return true;
    }

    @GetMapping("/return")
    public boolean returnChat(@RequestParam("name") String name) {
        List<User> userList = userRepository.findByName(name);
        if (userList.size()==0) return false;
        User user = userList.get(0);
        user.setExitFromChat(false);
        userRepository.save(user);

        String msgText = "Вернулся в чат "+ name;
        messageRepository.save(new ChatMessage(name, msgText));
        return true;
    }

    @GetMapping("/close")
    public boolean closeChat(@RequestParam("name") String name) {
        List<User> userList = userRepository.findByName(name);
        if (userList.size()==0) return false;
        User user = userList.get(0);
        userRepository.delete(user);

        String msgText = "Покинул чат "+ name;
        messageRepository.save(new ChatMessage(name, msgText));
        return true;
    }

    private void checkMsg(ChatMessage msg) {
        System.out.println(msg);
        if (msg == null) {
            throw new NullPointerException("Your message is null (empty)");
        }
        if (msg.getId() != null) {
            throw new IllegalArgumentException("You are not allowed to specify id manually");
        }

        String msgText = msg.getMsgText();
        if (msgText == null || msgText.length() == 0) {
            throw new IllegalArgumentException("Empty message text is not allowed");
        }

    }

}
