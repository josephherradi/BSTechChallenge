package com.backend.bt.demo.Service;

import com.backend.bt.demo.Modele.User;

public interface UserService {

    public User saveUser(User theUser);
    public User get(int theId);
    public void delete(int theId);
}
