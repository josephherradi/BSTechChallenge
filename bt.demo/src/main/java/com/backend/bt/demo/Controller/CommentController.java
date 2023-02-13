package com.backend.bt.demo.Controller;

import com.backend.bt.demo.Modele.Comment;
import com.backend.bt.demo.Modele.Recipe;
import com.backend.bt.demo.Modele.User;
import com.backend.bt.demo.Service.CommentService;
import com.backend.bt.demo.Service.RecipeService;
import com.backend.bt.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/recipe/{id}/saveComment")
    public ResponseEntity<Comment> saveComment(@PathVariable int id, @RequestBody Comment comment, HttpSession session, HttpServletRequest request){
        //nor working null ...
        //User loggedUser=(User) request.getSession().getAttribute("theUser");

        // hardcoded temp work around
        User loggedUser=userService.getbyName("user1");
        Recipe recipe=recipeService.get(id);
        comment.setUser(loggedUser);
        comment.setRecipe(recipe);
        Comment newComment=commentService.saveComment(comment);
        return new ResponseEntity<Comment>(newComment, HttpStatus.CREATED);
    }

    @RequestMapping(value="/recipe/{id}/commentsList",method = RequestMethod.GET)
    public List<Comment> commentsList(@PathVariable int id){
        List<Comment> commentsList = commentService.commentsListperRecipe(id);
        return commentsList;

    }

}
