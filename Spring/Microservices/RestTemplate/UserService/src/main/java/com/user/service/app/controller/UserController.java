package com.user.service.app.controller;

import com.user.service.app.dto.ResponseDto;
import com.user.service.app.model.User;
import com.user.service.app.service.UserServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danfe
 */


@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserServiceInter userServiceInter;
    
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User u){
        User savedUser = userServiceInter.saveUser(u);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId){
        ResponseDto responseDto = userServiceInter.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }
}
