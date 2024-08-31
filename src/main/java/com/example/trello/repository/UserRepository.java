package com.example.trello.repository;

import com.example.trello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);

//    User findById(int user_id);
}
