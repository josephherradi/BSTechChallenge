package com.backend.bt.demo.Controller;

import com.backend.bt.demo.Modele.User;
import com.backend.bt.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "True")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("identifiant") String identifiant, @RequestParam("password") String password, HttpSession session){

        User registredUser= userService.getbyName(identifiant);
        try{
            String registredId=registredUser.getName();
            String registredPwd=registredUser.getPassword();

            if(identifiant.equalsIgnoreCase(registredId) && password.equalsIgnoreCase(registredPwd)){
                session.setAttribute("user",identifiant);
                session.setAttribute("theUser",registredId);
                System.out.println(session.getAttribute("user") +" is connected");


                return "logged";

            } else {

            }

        } catch (NullPointerException e){

        }

        return "logged";
    }
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        System.out.println(session.getAttribute("user")+" is disconnected");
        session.invalidate();

        return "disconnected";


    }

    @PostMapping(value="saveUser")
    public ResponseEntity<User> createUser(@RequestBody User theUser){
        User newUser=userService.saveUser(theUser);


        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);

    }

}
