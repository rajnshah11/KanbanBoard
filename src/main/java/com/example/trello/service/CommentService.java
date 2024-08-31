package com.example.trello.service;

import com.example.trello.entity.Comment;
import com.example.trello.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
    public Comment getCommentById(int comment_id){

        return commentRepository.findById(comment_id).get();
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public List<Comment> getCommentByTaskId(int task_id){
        return commentRepository.findByTaskId(task_id);
    }
}
