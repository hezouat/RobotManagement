package com.robot.dao.mapper;

import com.robot.model.Robot;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hezouatz on 11/12/17.
 */
public interface IRobotMapper {

    @Insert("insert into robots(name) values(#{name})")
    @SelectKey(statement="call identity()", keyProperty="id",
      before=false, resultType=Long.class)
    int createRobot(Robot newRobot);

    @Select("select id, name  from robots WHERE id=#{id}")
    Robot findRobotById(Long id);

    @Select("select id, name from robots")
    List<Robot> findAll();

    @Delete("delete from robots where id=#{id}")
    void deleteRobotById(Long robotId);

}
