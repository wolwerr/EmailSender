package com.example.emailsender.model;

import lombok.Data;

@Data
public class User{

    private String name;
    private String nickname;
    private String email;
    private String password;

    public User(String name, String nickname, String email){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

}
