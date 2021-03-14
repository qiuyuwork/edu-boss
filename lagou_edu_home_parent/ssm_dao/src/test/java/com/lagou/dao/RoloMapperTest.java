package com.lagou.dao;

import com.lagou.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.server.RMIClassLoader;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:core/ApplicationContext_dao.xml")
public class RoloMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testFindAllRole() throws Exception{
        Role r = new Role();
        r.setName("限");

        List<Role> roles = roleMapper.findAllRole(r);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

}
