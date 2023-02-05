package com.backend.bt.demo.Service;

import com.backend.bt.demo.DAO.UserDAO;
import com.backend.bt.demo.Modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public User saveUser(User theUser) {
        return userDAO.save(theUser);
    }

    @Override
    public User get(int theId) {
        return userDAO.findById(theId).orElse(null);
    }

    @Override
    public void delete(int theId) {
        userDAO.deleteById(theId);

    }

    @Override
    public User getbyName(String identifiant) {
        User theUser= new User();
        List<User> ResultList=userDAO.findByIdentifiant(identifiant);
        try{
            theUser=ResultList.get(0);
        } catch (IndexOutOfBoundsException e){

        }
        return theUser;
    }
}
