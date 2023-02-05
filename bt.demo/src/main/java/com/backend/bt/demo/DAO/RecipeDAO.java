package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe,Integer> {

    @Query("select r from Recipe r where r.key_words= :Rkeywords")
    List<Recipe> findByKeywords(@Param("Rkeywords") String key_words);
}
