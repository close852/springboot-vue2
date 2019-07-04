package com.cjhm.repository;

import java.util.ArrayList;
import java.util.List;

import com.cjhm.entity.UserVO;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public List<UserVO> users = new ArrayList<>();

    public UserRepository() {
        users.add(UserVO.builder().userid(1L).username("jiwo").age(29).build());
        users.add(UserVO.builder().userid(2L).username("mira").age(28).build());
        users.add(UserVO.builder().userid(3L).username("jiho").age(27).build());
    }

    public List<UserVO> getUserList() {
        return this.users;
    }

    public UserVO createUser(String username, int age) {
        UserVO usr = UserVO.builder().username(username).age(age).userid((long) users.size() + 1).build();
        users.add(usr);
        return usr;
    }
}