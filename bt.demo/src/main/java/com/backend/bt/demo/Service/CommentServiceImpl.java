package com.backend.bt.demo.Service;

import com.backend.bt.demo.DAO.CommentDAO;
import com.backend.bt.demo.Modele.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements  CommentService{
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment saveComment(Comment theComment) {
        return commentDAO.save(theComment);
    }

    @Override
    public Comment get(int theId) {
        return commentDAO.findById(theId).orElse(null);
    }

    @Override
    public void delete(int theId) {
        commentDAO.deleteById(theId);

    }

    @Override
    public List<Comment> commentsListperRecipe(int id) {
        return commentDAO.finByRecipe(id);
    }
}
