package com.example.trello.repository;

import com.example.trello.entity.State;
import com.example.trello.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Integer> {
    public State findById(int state_id);
}
