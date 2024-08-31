package com.example.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "state_history")
public class StateHistory {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column
    int change_id;

    @Column
    String change_id_type;


    public StateHistory(Task task, User user,int change_id, String change_id_type){
       this.task = task;
       this.user = user;
       this.change_id = change_id;
       this.change_id_type = change_id_type;



    }




}
