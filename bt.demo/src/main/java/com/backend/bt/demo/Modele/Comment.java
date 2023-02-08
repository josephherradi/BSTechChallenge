package com.backend.bt.demo.Modele;


import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int comment_id;


    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name="recipe_id",updatable = false,insertable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name="user_id",updatable = false,insertable = false)
    private User user;


    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", text='" + text + '\'' +
                ", recipe=" + recipe +
                ", user=" + user +
                '}';
    }
}

