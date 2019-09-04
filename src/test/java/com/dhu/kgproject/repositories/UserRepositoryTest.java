package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUser(){
        User user = new User();
        user.setUsername("czj");
        user.setPassword("123456");
        userRepository.save(user);
    }

    @Test
    public void findByUsername(){

    }
}