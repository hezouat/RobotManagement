import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {Routes, RouterModule} from "@angular/router";
import {RobotComponent}  from "../robot/robot.component";

const routes: Routes = [
  { path: 'robots', component: RobotComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RobotRoutingModule { }
