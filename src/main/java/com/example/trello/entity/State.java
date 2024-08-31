package com.example.trello.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "State_TBL")
public class State {
    @Id
    @GeneratedValue
    private int id;



    private String state_name;


//    @JsonIgnore
//    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
//    Set<StateTask> tasksAssigned;
}
