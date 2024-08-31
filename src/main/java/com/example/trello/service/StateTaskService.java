package com.example.trello.service;
import com.example.trello.entity.StateTask;
import com.example.trello.repository.StateRepository;
import com.example.trello.repository.StateTaskRepository;
import com.example.trello.repository.TaskRepository;
import com.example.trello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StateTaskService {
    @Autowired
    private StateTaskRepository repository;

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    public StateTask saveTask(int task_id, int state_id,int user_id) {
        StateTask  stateTask = new StateTask(taskRepository.findById(task_id),stateRepository.findById(state_id),userRepository.findById(user_id).get());
        return repository.save(stateTask);
    }

    public List<String> getStateTasks(int task_id){
       return repository.getStateTasks(task_id);
    }
    public String getCurrentStateTasks(int task_id){
        return repository.getCurrentStateTasks(task_id);
    }
}
