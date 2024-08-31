package com.example.trello.entity;
import com.example.trello.repository.TaskRepository;

import com.example.trello.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "state_task")
public class StateTask {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "state_id")
    State state;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


    @Column
    private Timestamp createdOn;


    public StateTask(Task task, State state, User user){
        this.task = task;
        this.state = state;
        this.user = user;
        createdOn = new Timestamp(System.currentTimeMillis());;
    }


}
