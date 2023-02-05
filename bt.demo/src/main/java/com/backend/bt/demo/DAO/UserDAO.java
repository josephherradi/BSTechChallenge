package com.backend.bt.demo.DAO;

import com.backend.bt.demo.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
}
