package com.lagou.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lagou.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:core/ApplicationContext_dao.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAllUserByPage() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2020-07-12");
        Date end = sdf.parse("2020-07-14");

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> users = userMapper.findAllUserByPage("用户8666", null, null);
        for (User user : users) {
            System.out.println(objectMapper.writeValueAsString(user));
        }
    }

    @Test
    public void test38() throws Exception{
        System.out.println(UUID.randomUUID().toString().length());
    }
}
