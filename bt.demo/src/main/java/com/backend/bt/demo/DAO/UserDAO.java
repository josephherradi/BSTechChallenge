package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.name= :identifiant")
    List<User> findByIdentifiant(@Param("identifiant") String name);
}
