package com.example.trello.controller;

import com.example.trello.entity.State;
import com.example.trello.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StateController {
    @Autowired
    private StateService stateService;


    /**
     * This will add a state to the state table
     * @param state
     * @return
     */
    @PostMapping("/state/addState")
    public State addTask(@RequestBody State state) {
        return stateService.saveState(state);
    }

    /**
     * This will delete a specific state
     * @param state
     */
    @DeleteMapping("/state/deleteState")
    public void deleteState(@RequestBody State state) {
         stateService.deleteState(state.getId());
    }

    /**
     * This will bring all the states in the state table
     * @return
     */
    @GetMapping("/state/getStates")
    public List<State> getAllStates(){
        return stateService.getAllStates();
    }

    /**
     * This will print the details of the specific state
     * @param state_id
     * @return
     */
    @GetMapping("/state/getStates/{state_id}")
    public State getStateById(@PathVariable int state_id){
        return stateService.getStateById(state_id);
    }
}
