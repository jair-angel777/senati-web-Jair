package com.senati.resl_api.Controler;

import com.senati.resl_api.MODEL.Users;
import com.senati.resl_api.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserControllers {
    @Autowired
    UsersService usersService;

    @GetMapping("/api/Users")
    public List<Users> getAllUsers(){
      return usersService.getAllUsers();
    };
    @PostMapping("/api/user")
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {
        return usersService.saveUser(users);
    }
    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable("id")Integer id){
        usersService.deleteUser(id);
    }
    @PutMapping("/api/user/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Integer id, @RequestBody Users users) {
        return usersService.updateUser(id, users);
    }
}
