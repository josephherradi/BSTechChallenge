package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.User;

import java.util.List;

public interface UserService {

    public User saveUser(User theUser);
    public User get(int theId);
    public void delete(int theId);
    public User getbyName(String identifiant);
    public List<User> allUsers();

}
