package com.example.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comment_TBL")
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    private String comment_description;


    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
