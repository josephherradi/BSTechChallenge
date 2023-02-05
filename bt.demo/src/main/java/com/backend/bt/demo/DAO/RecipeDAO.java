package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDAO extends JpaRepository<Recipe,Integer> {
}
