package com.backend.bt.demo.Modele;

import javax.persistence.*;

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

    @Column(name="key_words")
    private String key_words;

    @Column(name="chef_name")
    private String chef_name;


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

    public String getKey_words() {
        return key_words;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }

    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", key_words='" + key_words + '\'' +
                ", chef_name='" + chef_name + '\'' +
                '}';
    }
}
