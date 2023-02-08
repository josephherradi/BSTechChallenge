package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment,Integer> {
    @Query("select c from Comment c where c.recipe.recipe_id= :recipe_pkid")
    List<Comment> finByRecipe(@Param("recipe_pkid") Integer recipe_id);
}
