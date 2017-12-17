package com.robot.controller;

import com.robot.model.Robot;
import com.robot.services.IRobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hezouatz on 11/12/17.
 */
@RestController
@RequestMapping("/rest/robots")
public class RobotController {

    private static final Logger LOG = LoggerFactory.getLogger(RobotController.class);

    @Autowired
    private IRobotService robotService;


    @RequestMapping(value = "/allRobots", method = RequestMethod.GET,produces = "application/json")
    public List<Robot> getAllRobots() {
        LOG.info("List robots " + robotService.findAll());
        return robotService.findAll();
    }

    @RequestMapping(value = "/getRobot/{robotId}", method = RequestMethod.GET)
    public Robot getRobot(@PathVariable("robotId") Long robotId) {
        return robotService.findRobotById(robotId);
    }


    @RequestMapping(value = "/createRobot", method = RequestMethod.POST)
    public synchronized ResponseEntity createRobot(@RequestBody Robot robot) {
         robotService.createRobot(robot);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }


    @RequestMapping(value = "/deleteRobot/{robotId}", method = RequestMethod.DELETE)
    public void deleteRobot(@PathVariable("robotId") Long robotId) {
        robotService.deleteRobot(robotId);
    }


}
