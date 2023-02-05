package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.Comment;

public interface CommentService {
    public Comment saveComment(Integer userId,Integer recipeId,Comment theComment);
    public Comment get(int theId);
    public void delete(int theId);
}
