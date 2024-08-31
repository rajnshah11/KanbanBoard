package com.example.trello.controller;


import com.example.trello.entity.StateTask;
import com.example.trello.entity.TaskUser;
import com.example.trello.repository.StateHistoryRepository;
import com.example.trello.repository.TaskUserRepository;
import com.example.trello.service.StateHistoryService;
import com.example.trello.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskUserController {
    @Autowired
    TaskUserService taskUserService;

    @Autowired
    StateHistoryService stateHistoryService;
    /**
     * This will assign user to a task
     * @param task_id
     * @param user_id
     * @return
     */
    @PostMapping("/{task_id}/assignUser/{user_id}")
    public TaskUser addTask(@PathVariable int task_id,
                            @PathVariable int user_id) {
        System.out.println("Task id -> " + task_id + " state id -> " + user_id);
        TaskUser taskUser = taskUserService.saveTask(task_id,user_id);
        stateHistoryService.addUserToTask(taskUser);
        return taskUser;
    }

    /**
     * This will remove an assigned user from the specific task.
     * @param task_id
     * @param user_id
     */
    @PostMapping("/{task_id}/removeUserFromTask/{user_id}")
    public void removeUserFromTask(@PathVariable int task_id,
                            @PathVariable int user_id) {

         taskUserService.removeUserFromTask(task_id,user_id);
         stateHistoryService.removeUserFromTask(task_id,user_id);
    }
}
