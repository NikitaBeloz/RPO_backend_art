package ru.bmstu.rpo.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.bmstu.rpo.entity.Museum;
import ru.bmstu.rpo.entity.Users;
import ru.bmstu.rpo.repository.UserRepository;

import java.util.*;

@Service
@Data
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> findById(Long id){
        return userRepository.findById(id);
    }

    public ResponseEntity<Object> createUsers(Users users) {
        try {
            Users nc = userRepository.save(users);
            return ResponseEntity.ok(nc);
        } catch (Exception ex) {
            String error;
            if (ex.getMessage().contains("users.login_UNIQUE") || ex.getMessage().contains("users.email_UNIQUE"))
                error = "countyalreadyexists";
            else
                error = "undefinederror";
            Map<String, String> map = new HashMap<>();
            map.put("error", error);
            return ResponseEntity.ok(map);
        }
    }

    public ResponseEntity<Users> updateUsers(Long usersId, Users usersDetails) {
        Optional<Users> cc = userRepository.findById(usersId);
        if (cc.isPresent()) {
            Users users = entityForUpdate(usersId, usersDetails);
            userRepository.save(users);
            return ResponseEntity.ok(users);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
    }

    public ResponseEntity<Object> deleteUsers(Long usersId) {
        Optional<Users> users = userRepository.findById(usersId);
        Map<String, Boolean> resp = new HashMap<>();
        if (users.isPresent()) {
            userRepository.delete(users.get());
            resp.put("deleted", Boolean.TRUE);
        } else
            resp.put("deleted", Boolean.FALSE);
        return ResponseEntity.ok(resp);
    }

    private Users entityForUpdate(Long usersId, Users usersDetails){
        Optional<Users> cc = userRepository.findById(usersId);
        Users users = cc.get();
        users.login = usersDetails.login;
        users.email = usersDetails.email;
        return users;
    }

    public ResponseEntity<Set<Museum>> getUsersMuseum(Long usersId) {
        Optional<Users> cc = userRepository.findById(usersId);
        if (cc.isPresent()) {
            return ResponseEntity.ok(cc.get().museums);
        }
        return ResponseEntity.ok( new HashSet<>());
    }
}
