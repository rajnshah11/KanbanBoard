package com.example.trello.repository;

import com.example.trello.entity.State;
import com.example.trello.entity.StateTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateTaskRepository extends JpaRepository<StateTask,Integer> {
    @Query(value = "select state_tbl.state_name, state_task.created_on from  trello.state_tbl, trello.state_task where state_task.task_id = ?1 and state_tbl.state_id = state_task.state_id;)",nativeQuery = true)
    public List<String> getStateTasks(int task_id);

    @Query(value = "SELECT state_tbl.state_name\n" +
          "FROM trello.state_task,trello.state_tbl\n" +
          "WHERE state_task.created_on = (SELECT MAX(state_task.created_on) FROM trello.state_task where state_task.task_id = ?1)\n" +
          "and state_tbl.state_id = state_task.state_id\n" +
          "ORDER BY id DESC\n" +
          "LIMIT 1 ", nativeQuery = true)
    public String getCurrentStateTasks(int task_id);

    public List<StateTask> findByTaskId(int task_id);

}
