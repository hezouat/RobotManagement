import {Component, OnInit} from "@angular/core";
import { Router } from "@angular/router";
import { Robot } from "../robot";
import { RobotService } from "../robot.service";

@Component({
  selector: 'app-robot',
  templateUrl: './robot.component.html',
  styleUrls: ['./robot.component.css']
})
export class RobotComponent implements OnInit {

  robots: Robot[];
  newRobot: Robot;
  selectedRobot: Robot;

  constructor(private router: Router, private robotService: RobotService) { }

  ngOnInit() {
    this.robotService.getRobots().then(robots => this.robots=robots);
    this.newRobot = new Robot();
  }


  createRobot(robot: Robot): void {

    this.robotService.createRobot(robot)
      .then(robot => {
        this.robots.push(robot);
        this.selectedRobot = null;
      });
  }


  findRobot(id: number): void {

    this.robotService.getRobot(id)
      .then(robot => {
        this.robots.push(robot);
        this.selectedRobot = robot;
      });
  }


  deleteRobot(robot: Robot): void {
    this.robotService
      .deleteRobot(robot)
      .then(() => {
        this.robots = this.robots.filter(h => h !== robot);
        if (this.selectedRobot === robot) { this.selectedRobot = null; }
      });
  }

}
