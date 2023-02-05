package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment,Integer> {
}
