package com.avalon.ymjhuahua.controller;

import com.avalon.base.entity.Person;
import com.avalon.common.controller.AbstractController;
import com.avalon.ymjhuahua.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author huhao
 * @date 2018/06/16:48
 */
@RestController
public class YmjhuahuaController extends AbstractController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/test/{userId}/{userName}")
    public String test(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
        Person person = new Person();
        person.setUserId(userId);
        person.setUserName(userName);
        testService.insert(person);
        return "success";
    }

    @RequestMapping(value = "/get")
    public List<Person> getAll() {
        return testService.select();
    }
}
