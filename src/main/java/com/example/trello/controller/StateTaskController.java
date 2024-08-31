package com.example.trello.controller;

import com.example.trello.entity.StateHistory;
import com.example.trello.entity.StateTask;
import com.example.trello.entity.Task;
import com.example.trello.repository.StateRepository;
import com.example.trello.repository.TaskRepository;
import com.example.trello.repository.UserRepository;
import com.example.trello.service.StateHistoryService;
import com.example.trello.service.StateTaskService;
import com.example.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StateTaskController {

    @Autowired
    private StateTaskService stateTaskService;

    @Autowired
    private StateHistoryService stateHistoryService;
    /**
     * This will add state to the created task.
     * This will help store all the history of state changes as the created_on/modified_on column will store the timestamp of whenever the state change happens.
     * @param stateTask
     * @return
     */
    @PostMapping("/addStateToTask")
    public StateTask addTask(@RequestBody StateTask stateTask) {

        StateTask stateTask1 = stateTaskService.saveTask(stateTask.getTask().getId(),stateTask.getState().getId(),stateTask.getUser().getId());
        stateHistoryService.addStateToTask(stateTask1);
        return stateTask1;
    }

    /**
     * This will bring all the state history of that specific task given as a request
     * @param task_id
     * @return
     */
    @GetMapping("/getAllStateChanges/{task_id}")
    public List<String> getAllStateChanges(@PathVariable int task_id){
        return stateTaskService.getStateTasks(task_id);
    }

    /**
     * This will give the current state of that task
     * @param task_id
     * @return
     */

    @GetMapping("/getCurrentTaskState/{task_id}")
    public String getCurrentTaskState(@PathVariable int task_id){
        return stateTaskService.getCurrentStateTasks(task_id);
    }
}
