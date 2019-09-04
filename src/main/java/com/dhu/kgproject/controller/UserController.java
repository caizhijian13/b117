package com.dhu.kgproject.controller;

import com.dhu.kgproject.domain.User;
import com.dhu.kgproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    //实现register功能
    @PostMapping("/handleRegister")
    public String handleRegister(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 Map<String,Object> map){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userRepository.findByUsername(username) == null) {
            userRepository.save(user);
            return "login";
        }
        else
        {
            map.put("msg","用户名已存在 ");
            return "register";
        }
    }

    //实现login功能
    @PostMapping("/handleLogin")
    public String handleLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session, Map<String,Object> map){
        User user = userRepository.findByUsernameAndPassword(username,password);
        if(user != null){
            session.setAttribute("username",user.getUsername());
            return "redirect:/index";
        }else {
            map.put("msg","用户名或密码错误 ");
            return "login";
        }
    }

    //实现logout功能
    @RequestMapping("/logout")
    public String handleLogout(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }
}
