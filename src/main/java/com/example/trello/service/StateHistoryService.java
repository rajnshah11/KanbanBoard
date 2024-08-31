package com.example.trello.service;

import com.example.trello.entity.*;
import com.example.trello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateHistoryService {

    @Autowired
    StateHistoryRepository stateHistoryRepository;

    @Autowired
    TaskUserRepository taskUserRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StateRepository stateRepository;

    /**
     * Add to the history table if the user is assigned to task
     * @param taskUser
     */
    public void addUserToTask(TaskUser taskUser){
        Task task = taskRepository.findById(taskUser.getTask().getId());
        StateHistory stateHistory = new StateHistory(task,taskUser.getUser(),taskUser.getId(),"User "+taskUser.getUser().getId()+" assigned to task "+task.getId());
        stateHistoryRepository.save(stateHistory);
    }

    /**
     * Add to the history table if the user is removed from teh task
     * @param task_id
     * @param user_id
     */
    public void removeUserFromTask(int task_id, int user_id){
       Task task= taskRepository.findById(task_id);
       User user = userRepository.findById(user_id).get();
       StateHistory stateHistory = new StateHistory(task,user,task_id,"User "+user_id +"unassigned from task "+task_id);
       stateHistoryRepository.save(stateHistory);

    }

    /**
     * Add in the history table if the task is changed or assigned to the task
     * @param stateTask
     */

    public void addStateToTask(StateTask stateTask){
        Task task = taskRepository.findById(stateTask.getTask().getId());
        StateHistory stateHistory = new StateHistory(task,stateTask.getUser(),stateTask.getId().intValue(),"New state assigned to task "+task.getId());
        stateHistoryRepository.save(stateHistory);
    }

    /**
     * Add in the history table if the comment is added to the task
     * @param comment
     */
    public void addCommentToTask(Comment comment){
        StateHistory stateHistory = new StateHistory(comment.getTask(),comment.getUser(),comment.getId(),"Comment added to task "+comment.getTask().getId());
        stateHistoryRepository.save(stateHistory);
    }
}
