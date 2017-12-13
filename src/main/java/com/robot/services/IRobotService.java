package com.robot.services;

import com.robot.model.Robot;

import java.util.List;

/**
 * Created by hezouatz on 11/12/17.
 */
public interface IRobotService {

    List<Robot> findAll();

    Robot findRobotById(Long id);

    void deleteRobot(Long id);

    void createRobot(Robot newRobot);
}
