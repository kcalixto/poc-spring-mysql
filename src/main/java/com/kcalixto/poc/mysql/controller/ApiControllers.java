package com.kcalixto.poc.mysql.controller;

import com.kcalixto.poc.mysql.modules.User;
import com.kcalixto.poc.mysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getPage(){
        return "welcome!";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);

        return "done!! :)";
    }

    @PutMapping("/save/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();

        updatedUser.setName(user.getName());

        userRepo.save(updatedUser);

        return "Done o_o";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User user = userRepo.findById(id).get();
        userRepo.delete(user);

        return "deleted :(";
    }

}
