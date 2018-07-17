package com.avalon.ymjhuahua.controller;

import com.avalon.base.entity.Person;
import com.avalon.common.controller.AbstractController;
import com.avalon.ymjhuahua.service.TestService;
import com.avalon.ymjhuahua.service.TestSpringService;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @author huhao
 * @date 2018/06/16:48
 */
@RestController
public class YmjhuahuaController extends AbstractController {

    private TestService testService;

    private final int sizeOfNumberSet = Integer.MAX_VALUE >> 4;

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
        Random generator = new Random();
        int error = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet);
        int number;
        for (int i = 0; i < sizeOfNumberSet; i++) {
            number = generator.nextInt();
            if (filter.mightContain(number) != hashSet.contains(number)) {
                error++;
            }
            filter.put(number);
            hashSet.add(number);
        }

        System.out.println("Error count: " + error + ", error rate = " + String.format("%f", (float) error / (float) sizeOfNumberSet));

        return testService.select();
    }

    @RequestMapping(value = "/testSpring")
    public String getTestResult() {
        BeanFactory bean = new XmlBeanFactory(new ClassPathResource("testspring.xml"));
        TestSpringService testSpringService = (TestSpringService) bean.getBean("test");
        return testSpringService.testSpringMethod("test success");
    }
    
    @RequestMapping(value = "/test/{abc}")
    public String test1(@PathVariable("abc") String abc) {
        if (abc.equals("a")) {
            throw new NullPointerException();
        }
        logger.info("执行目标代码");
        return "success" + abc;
    }
}
