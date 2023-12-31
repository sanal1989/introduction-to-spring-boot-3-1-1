package com.springBoot.springboot.controller;

import com.springBoot.springboot.dto.UserDto;
import com.springBoot.springboot.model.Car;
import com.springBoot.springboot.model.User;
import com.springBoot.springboot.service.UserService;
import com.springBoot.springboot.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService = new UserServiceImp();

    @GetMapping(value = "/")
    public String getAll(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(ModelMap model, @PathVariable Integer id){
        userService.deleteById(id);
        return getAll(model);
    }

    @PostMapping(value = "/{id}")
    public String editUser(ModelMap model, @PathVariable Integer id, @RequestBody UserDto userDto){
        Car car = new Car(userDto.getCarModel(), userDto.getCarColor(), userDto.getCarYear());
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), car);
        user.setId((long)id);
        userService.updateUser(user);
        return getAll(model);
    }

    @PostMapping(value = "/edit")
    public String addUser(ModelMap model, @RequestBody UserDto userDto){
        Car car = new Car(userDto.getCarModel(), userDto.getCarColor(), userDto.getCarYear());
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), car);
        userService.add(user);
        return getAll(model);
    }
}
