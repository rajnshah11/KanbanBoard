package com.example.trello.repository;

import com.example.trello.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByTaskId(int task_id);
}

