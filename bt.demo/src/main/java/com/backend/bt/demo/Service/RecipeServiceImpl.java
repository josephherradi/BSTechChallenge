package com.backend.bt.demo.Service;


import com.backend.bt.demo.DAO.RecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl {
    @Autowired
    private RecipeDAO recipeDAO;
}
