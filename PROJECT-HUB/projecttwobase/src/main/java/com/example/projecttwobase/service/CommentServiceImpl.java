package com.example.projecttwobase.service;


import com.example.projecttwobase.config.ExceptionHandler;
import com.example.projecttwobase.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.projecttwobase.model.Comment;
import com.example.projecttwobase.repository.CommentRepository;
import com.example.projecttwobase.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(@RequestBody Comment comment, Long postId ){
       Post post =  postRepository.getPostById(postId);
       comment.setPost(post);
       return commentRepository.save(comment);
    }

//    public List<Comment> getCommentByUsername (String username){
//        return commentRepository.findAllByUsername(username);
//    }
    @Override
    public ResponseEntity<Object> deleteCommentByCommentId (Long commentId){
        return commentRepository.findById(commentId).map(comment ->{
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ExceptionHandler("Comment not found with id " + commentId));

    }
}
