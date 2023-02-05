package com.backend.bt.demo.Service;

import com.backend.bt.demo.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDAO userDAO;
}
