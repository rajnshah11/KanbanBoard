package com.example.trello.service;

import com.example.trello.entity.StateTask;
import com.example.trello.entity.TaskUser;
import com.example.trello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskUserService {
    @Autowired
    private TaskUserRepository repository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    public TaskUser saveTask(int task_id, int user_id) {
        TaskUser taskUser = new TaskUser(taskRepository.findById(task_id),userRepository.findById(user_id).get());
        return repository.save(taskUser);
    }

    public void removeUserFromTask(int task_id, int user_id) {
        repository.removeUserFromTask(task_id,user_id);
    }


}
