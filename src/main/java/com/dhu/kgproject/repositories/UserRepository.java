package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);
}
