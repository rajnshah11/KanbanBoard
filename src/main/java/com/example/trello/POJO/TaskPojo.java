package com.example.trello.POJO;

import com.example.trello.entity.User;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class TaskPojo {


    Timestamp created_on;
    String description;
    String state_name;
    String name;
    Timestamp due_date;


    public TaskPojo(Timestamp created_on, String description, String state_name, String name, Timestamp due_date){
        this.created_on = created_on;
        this.description = description;
        this.state_name = state_name;
        this.name = name;
        this.due_date = due_date;
    }

}
