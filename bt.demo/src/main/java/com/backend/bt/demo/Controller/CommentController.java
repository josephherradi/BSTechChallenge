package com.backend.bt.demo.Controller;

import com.backend.bt.demo.Modele.Comment;
import com.backend.bt.demo.Modele.User;
import com.backend.bt.demo.Service.CommentService;
import com.backend.bt.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/recipe/{id}/saveComment")
    public ResponseEntity<Comment> saveComment(@PathVariable int id, @RequestBody Comment comment, HttpSession session, HttpServletRequest request){
        String utilisateur= (String) request.getSession().getAttribute("user");
        User user=userService.getbyName(utilisateur);
        Comment newComment=commentService.saveComment(user.getUser_id(),id,comment);
        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(value="/recipe/{id}/commentsList",method = RequestMethod.GET)
    public List<Comment> commentsList(@PathVariable int id){
        List<Comment> commentsList = commentService.commentsListperRecipe(id);
        return commentsList;

    }

}
