package com.example.emailsender.messages;

import com.example.emailsender.model.User;

public class EmailMessages {

    public static String createTitle(User user){
        return
        user.getNickname() + " your data was received!";
    }

    public static String messageToNewUser(User user, String password){
        return

                "Hi " + user.getName() +"! Welcome to Ataria. "
                +"Your data and password for access is below.\n\n"
                +"==============================================================\n"
                +"Name: " + user.getName() + "\n"
                +"Nickname: " + user.getNickname() + "\n"
                +"E-mail: " + user.getEmail() + "\n"
                +"Password: " + password + "\n"
                +"==============================================================\n\n"
                +"Is very important access your account and change your password.\n"
                +"www.ataria.dev";
    }
}
