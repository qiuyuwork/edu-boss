package com.lagou.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagou.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:core/ApplicationContext_dao.xml")
public class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void findSubMenuListByPid() throws JsonProcessingException {
        List<Menu> menus = menuMapper.findSubMenuListByPid(-1);
        System.out.println(
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(menus)
        );

    }
}
