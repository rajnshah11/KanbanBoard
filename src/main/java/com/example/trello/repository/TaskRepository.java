package com.example.trello.repository;

import com.example.trello.entity.Task;
import com.example.trello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    public Task findById(int task_id);
}
