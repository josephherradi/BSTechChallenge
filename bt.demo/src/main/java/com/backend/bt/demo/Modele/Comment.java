package com.backend.bt.demo.Modele;


import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int comment_id;

    @Column(name="recipe_id")
    private int recipe_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="text")
    private String text;


    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", recipe_id=" + recipe_id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                '}';
    }
}

