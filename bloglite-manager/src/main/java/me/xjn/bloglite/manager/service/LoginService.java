package me.xjn.bloglite.manager.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Object[] login(String username, String password, boolean remember){
        if (username.equals("admin") && password.equals("123456")){
            return new Object[]{true, ""};
        }
        else{
            return new Object[]{false, "用户名或密码错误"};
        }
    }
}
