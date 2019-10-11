package com.example.projecttwobase.service;

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

    //SAVES A COMMENT IN THE COMMENT REPOSITORY
    public Comment createComment(@RequestBody Comment comment, Long postId ){
       Post post =  postRepository.getPostById(postId);
       comment.setPost(post);
       return commentRepository.save(comment);
    }

    //FINDS ALL COMMENTS USING A POST'S ID
    public List<Comment> getCommentsByPostId (Long postId){
        return commentRepository.findAllByPostId(postId);
    }

//    public List<Comment> getCommentByUsername (String username){
//        return commentRepository.findAllByUsername(username);
//    }

    //DELETES A COMMENT FROM THE COMMENT REPOSITORY
    @Override
    public ResponseEntity<Object> deleteCommentByCommentId (Long commentId){
        Comment comment = commentRepository.getCommentById(commentId);
        commentRepository.delete(comment);

        return null;
    }
}
