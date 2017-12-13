import {Component, OnInit} from "@angular/core";
import { Robot } from './robot';
import { RobotService } from './robot.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'robot';

  ngOnInit() {

  }
}
