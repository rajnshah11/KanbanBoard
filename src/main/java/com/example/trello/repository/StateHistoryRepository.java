package com.example.trello.repository;

import com.example.trello.entity.StateHistory;
import com.example.trello.entity.StateTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateHistoryRepository extends JpaRepository<StateHistory,Integer> {

}
