package com.example.trello.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_TBl")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;

}
