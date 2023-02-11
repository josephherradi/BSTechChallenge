package com.backend.bt.demo.Modele;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    private int ingredient_id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinColumn(name = "recipe_id")
    private List<Recipe> recipes;

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}


