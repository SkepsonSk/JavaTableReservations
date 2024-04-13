package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.command.CreateUserCommand;
import pl.pollub.javatablereservations.dto.CreateUserDto;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.iterator.Iterator;
import pl.pollub.javatablereservations.iterator.UserOrganization;
import pl.pollub.javatablereservations.service.UserService;
import pl.pollub.javatablereservations.template.CreateUserActivationService;
import pl.pollub.javatablereservations.template.UserActivationService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/users/iterator")
    public User getUsersIterator() {
        Iterator<User> iterator = new UserOrganization(this.userService.getUsers()).createIterator();
        return iterator.next();
    }

    @PostMapping(value = "/create_user")
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        CreateUserCommand command = new CreateUserCommand(this.userService, createUserDto);
        command.execute();
    }

    @PostMapping(value = "/edit_user")
    public void editUser(@RequestBody CreateUserDto createUserDto) {
        this.userService.saveUser(createUserDto);
    }

    @PostMapping(value = "/activate_user")
    public void activateUser(@RequestBody CreateUserDto createUserDto) {
        UserActivationService activationService = new CreateUserActivationService(this.userService, createUserDto);
        activationService.activateUser();
    }

}
