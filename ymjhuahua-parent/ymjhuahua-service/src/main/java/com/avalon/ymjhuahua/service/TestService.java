package com.avalon.ymjhuahua.service;

import com.avalon.base.entity.Person;
import com.avalon.ymjhuahua.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void insert(Person person) {
        userMapper.insert(person);
    }

    public List<Person> select() {
        return userMapper.selectAllUser();
    }
}
