import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import {AppComponent} from "./app.component";
import {RobotComponent} from "./robot/robot.component";
import { RobotRoutingModule } from './robot-routing/robot-routing.module';
import { RobotService } from './robot.service';


@NgModule({
  declarations: [
    AppComponent,
    RobotComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RobotRoutingModule
  ],
  providers: [RobotService],
  bootstrap: [AppComponent]
})
export class AppModule { }

