package com.senati.resl_api.Service;

import com.senati.resl_api.MODEL.Response;
import com.senati.resl_api.MODEL.Users;
import com.senati.resl_api.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public ResponseEntity<Users> saveUser(@RequestBody Users users){
        return new ResponseEntity<>(usersRepository.save(users), HttpStatus.OK);
    }

    public Response deleteUser(@PathVariable("id")Integer id) {
        Optional<Users>optionalUsers = usersRepository.findById(id);
        Response response = new Response();
        if (optionalUsers.isPresent()){
            response.setCode(200);
            response.setStatus("success");
            response.setMessage("la fila con el id : " + id + "lo han matado");
            return response;
        }
        response.setCode(404);
        response.setStatus("error");
        response.setMessage("el usuario se ha salvado");
        return response;
    }


    public ResponseEntity<Users> updateUser(@PathVariable("id") Integer id, @RequestBody Users users) {
        Optional<Users> optionalUsers = usersRepository.findById(id);

        Users user = new Users();
        if (optionalUsers.isPresent()) {
            user.setId(id);
            user.setName(users.getName());
            user.setLastname(users.getLastname());
            return new ResponseEntity<>(usersRepository.save(user), HttpStatus.OK);
        }

        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }



}
