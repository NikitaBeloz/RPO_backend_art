package ru.bmstu.rpo.controller;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.rpo.entity.Museum;
import ru.bmstu.rpo.entity.Users;
import ru.bmstu.rpo.service.UserService;

import java.util.List;
import java.util.Set;

@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
@Data
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody Users users) {
        return userService.createUsers(users);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Long usersId, @RequestBody Users usersDetails) {
        return userService.updateUsers(usersId, usersDetails);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long usersId) {
        return userService.deleteUsers(usersId);
    }

    @GetMapping("/{id}/paintings")
    public ResponseEntity<Set<Museum>> getUserPainting(@PathVariable(value = "id") Long usersId) {
        return userService.getUsersMuseum(usersId);
    }

    @PostMapping("/{id}/addmuseums")
    public ResponseEntity<Object> addMuseums(@PathVariable(value = "id") Long userId, @Valid @RequestBody Set<Museum> museums) {
        return ResponseEntity.ok(userService.addMuseums(userId, museums));
    }

    @PostMapping("/{id}/removemuseums")
    public ResponseEntity<Object> removeMuseums(@PathVariable(value = "id") Long userId, @Valid @RequestBody Set<Museum> museums) {
        return ResponseEntity.ok(userService.removeMuseums(userId, museums));
    }
}
