package com.robot.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by hezouatz on 11/12/17.
 */
public class Robot implements Serializable {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;

        Robot robot = (Robot) o;

        if (!getId().equals(robot.getId())) return false;
        return getName().equals(robot.getName());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
