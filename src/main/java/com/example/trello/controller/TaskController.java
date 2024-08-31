package com.example.trello.controller;

import com.example.trello.POJO.TaskPojo;
import com.example.trello.entity.Comment;
import com.example.trello.entity.StateHistory;
import com.example.trello.entity.Task;
import com.example.trello.repository.CommentRepository;
import com.example.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentRepository commentRepository;


    /**
     * This will add a task
     * @param task
     * @return
     */

    @PostMapping("/task/addTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task newTask = taskService.saveTask(task);

        if(newTask == null )
            throw new RuntimeException("The specific Task could not be saved");

        return new ResponseEntity<>(newTask, HttpStatus.OK);

    }

    /**
     * This will edit description of the specific task
     * @param task
     * @return
     */

    @PutMapping("/task/editDescription")
    public ResponseEntity<Task> editDescription(@RequestBody Task task){
        Task newTask = taskService.editDescription(task);

        if(newTask == null)
            throw new RuntimeException("Editing was unsuccessful");
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    /**
     * This will delete a specific task
     * @param task_id
     * @return
     */

    @DeleteMapping("/task/deleteTask/{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable int task_id){
        taskService.deleteTask(task_id);
        return new ResponseEntity<>("Deletion was successful", HttpStatus.OK);
    }


    /**
     * This will bring all the previous and current state changes with all the task details,comments details  and users assigned details.
     * @param task_id
     * @return
     */
    @GetMapping("/task/getTaskDetails/{task_id}")
    public Map getTasks(@PathVariable int task_id){
        Map map = new HashMap<>();
        List<TaskPojo> taskPojos = taskService.getTaskDetails(task_id);
        map.put("Task details",taskPojos);
        List<Comment> comments = commentRepository.findByTaskId(task_id);
        map.put("Comments", comments);
        map.put("Status", HttpStatus.OK);
        return map;
    }

}
