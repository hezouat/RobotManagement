package com.robot;


import com.robot.dao.mapper.IRobotMapper;
import com.robot.model.Robot;
import  static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

/**
 * Created by hezouatz on 13/12/17.
 */

public class MyBatisSpringBootTests extends RobotManagementApplicationTests {

    @Autowired
    private IRobotMapper robotMapper;


    @Test
    public void findAllRobots() {

        List<Robot> robots = robotMapper.findAll();
        assertTrue(robots.isEmpty());
    }




}
