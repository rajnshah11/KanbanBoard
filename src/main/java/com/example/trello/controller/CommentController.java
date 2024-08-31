package com.example.trello.controller;
import com.example.trello.entity.Comment;
import com.example.trello.service.CommentService;
import com.example.trello.service.StateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private StateHistoryService stateHistoryService;

    /**
     * This will add Comment to a specific task
     * @param comment
     * @return
     */
    @PostMapping("/comment/addComment")
    public Comment addComment(@RequestBody Comment comment){

        Comment new_comment = commentService.saveComment(comment);
        stateHistoryService.addCommentToTask(new_comment);
        return new_comment;
    }

    /**
     * This will print the specific comment
     * @param comment_id
     * @return
     */

    @GetMapping("/comment/getComment/{comment_id}")
    public Comment getCommentById(int comment_id){
        return commentService.getCommentById(comment_id);
    }

    /**
     * This will bring all the comments
     * @return
     */
    @GetMapping("/comment/getAllComments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    /**
     * This will print the list of comments of that specific task
     * @param task_id
     * @return
     */
    @GetMapping("/comment/getCommentOfTask/{task_id}")
    public List<Comment> getCommentOfTask(@PathVariable int task_id){
        return commentService.getCommentByTaskId(task_id);
    }
}
