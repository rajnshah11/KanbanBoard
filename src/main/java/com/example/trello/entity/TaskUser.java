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
@Table(name = "task_user")
public class TaskUser {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;




    public TaskUser(Task task, User user){
        this.task = task;
        this.user = user;

    }


}
