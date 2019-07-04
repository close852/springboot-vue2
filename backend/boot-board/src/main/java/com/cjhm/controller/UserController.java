package com.cjhm.controller;

import java.util.ArrayList;
import java.util.List;

import com.cjhm.entity.ResponseVO;
import com.cjhm.entity.UserVO;
import com.cjhm.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseVO<?> getUsers() {
        ResponseVO<List<UserVO>> resp = new ResponseVO<>();
        List<UserVO> users = userRepository.getUserList();

        resp.setResponse(users);
        log.info("\r\n-> response : {},  {}", users.getClass().getName(), users);
        return resp;
    }

    @GetMapping("/{id}")
    public ResponseVO<?> getUser(@PathVariable Long id) {
        ResponseVO<UserVO> resp = new ResponseVO<>();
        List<UserVO> users = userRepository.getUserList();
        UserVO user = users.stream().filter(u -> u.getUserid() == id).findFirst().orElse(new UserVO());
        resp.setResponse(user);
        log.info("\r\n-> response : {},  {}", users.getClass().getName(), user);
        return resp;
    }

    @PostMapping
    public ResponseVO<?> createUser(@RequestParam String username, int age) {
        ResponseVO<UserVO> resp = new ResponseVO<>();
        UserVO user = userRepository.createUser(username, age);
        resp.setResponse(user);
        log.info("\r\n-> response : {},  {}", user.getClass().getName(), user);
        return resp;
    }
}