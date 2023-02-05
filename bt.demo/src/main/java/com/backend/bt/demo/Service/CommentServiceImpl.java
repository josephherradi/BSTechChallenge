package com.backend.bt.demo.Service;

import com.backend.bt.demo.DAO.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {
    @Autowired
    private CommentDAO commentDAO;
}
