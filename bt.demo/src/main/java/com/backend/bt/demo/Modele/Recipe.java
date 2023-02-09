package com.backend.bt.demo.Modele;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Recipe")

public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="recipe_id")
    private int recipe_id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User chef;

    @ManyToMany
    @JoinColumn(name="ingredient_id", updatable = false)
    private List<Ingredient> ingredients;


    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", chef=" + chef +
                ", ingredients=" + ingredients +
                '}';
    }
}
