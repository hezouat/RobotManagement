package com.robot.services.impl;

import com.robot.dao.mapper.IRobotMapper;
import com.robot.model.Robot;
import com.robot.services.IRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hezouatz on 11/12/17.
 */
@Service
public class RobotService implements IRobotService {

    @Autowired
    private IRobotMapper iRobotMapper;

    @Override
    public Robot findRobotById(Long id) {
        return iRobotMapper.findRobotById(id);
    }

    @Override
    public void deleteRobot(Long id) {
        iRobotMapper.deleteRobotById(id);
    }

    @Override
    public void createRobot(Robot newRobot) {
         iRobotMapper.createRobot(newRobot);
    }

    @Override
    public List<Robot> findAll() {
        return iRobotMapper.findAll();
    }
}
