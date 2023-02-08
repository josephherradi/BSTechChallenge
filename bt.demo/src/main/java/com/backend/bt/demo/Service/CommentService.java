package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.Comment;

import java.util.List;

public interface CommentService {
    public Comment saveComment(Comment theComment);
    public Comment get(int theId);
    public void delete(int theId);
    public List<Comment> commentsListperRecipe(int id);
}
