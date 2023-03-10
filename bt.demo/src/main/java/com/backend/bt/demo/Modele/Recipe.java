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
    @JoinColumn(name="ingredient_id")
    private List<Ingredient> ingredients;

    @Column(name="image_url")
    private String imageURL;


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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
