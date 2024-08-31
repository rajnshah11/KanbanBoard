package com.example.trello.service;

import com.example.trello.entity.State;
import com.example.trello.entity.Task;
import com.example.trello.repository.StateRepository;
import com.example.trello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository repository;
    public State saveState(State state) {
        return repository.save(state);
    }

    public void deleteState(int id) {
         repository.deleteById(id);
    }
    public List<State> getAllStates(){
        return repository.findAll();
    }

    public State getStateById(int id){
        return repository.findById(id);
    }
}
