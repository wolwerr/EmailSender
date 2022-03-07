package com.example.emailsender.services;

import com.example.emailsender.email.SendEmailService;
import com.example.emailsender.messages.EmailMessages;
import com.example.emailsender.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private SendEmailService sendEmailService;

    public User save(User user){
        this.validUserData(user);

        var newUser = new User(user.getName(), user.getNickname(), user.getEmail());
        newUser.setPassword(UUID.randomUUID().toString());

        this.sendEmailService.enviar(user.getEmail(),
        EmailMessages.createTitle(user), EmailMessages.messageToNewUser(user, newUser.getPassword()));

        newUser.setPassword("***********");

        return newUser;
    }

    public void validUserData(User user){
        if(user.getName() == null || user.getNickname() == null || user.getEmail() == null){
            throw new RuntimeException("All fields need be informed.");
        }
    }
}
