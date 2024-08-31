package com.example.trello.service;
import com.example.trello.POJO.TaskPojo;
import com.example.trello.entity.*;
import com.example.trello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    @Autowired
    private StateTaskRepository stateTaskRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Task saveTask(Task task) {
        return repository.save(task);
    }


    public Task editDescription(Task task){
        Task newTask =  repository.findById(task.getId());
        newTask.setDescription(task.getDescription());
        return repository.save(newTask);
    }

    /**
     * This will delete a task and the comments posted on that task
     * @param task_id
     */
    public void deleteTask(int task_id){
        List<Comment> comments = commentRepository.findByTaskId(task_id);
        for(Comment comment: comments)
            commentRepository.deleteById(comment.getId());
        repository.deleteById(task_id);
    }

    /**
     * This will make a POJO having all the task details with state,user and comment details
     * @param task_id
     * @return
     */
    public List<TaskPojo> getTaskDetails(int task_id){
        List<TaskPojo> taskPojos = new ArrayList<>();
        Task newTask = repository.findById(task_id);
        List<StateTask> stateTask = stateTaskRepository.findByTaskId(newTask.getId());
        for(StateTask stateTask1: stateTask){
            TaskPojo taskPojo = new TaskPojo(stateTask1.getCreatedOn(),stateTask1.getTask().getDescription(),stateTask1.getState().getState_name(),stateTask1.getUser().getName(),stateTask1.getTask().getDue_date());
            taskPojos.add(taskPojo);
        }
        return taskPojos;
    }

    }

