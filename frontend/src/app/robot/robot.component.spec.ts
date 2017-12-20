import {async, ComponentFixture, TestBed} from "@angular/core/testing";
import {RobotComponent} from "./robot.component";
import { Renderer,NgModule } from '@angular/core';
import {Router, RouterOutlet, RouterModule, Routes} from "@angular/router";
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Robot} from "../robot";
import { RobotService } from "../robot.service";
import {APP_BASE_HREF} from "@angular/common";


const routes: Routes = [
  { path: 'robots', component: RobotComponent }
];

describe('RobotComponent', () => {
  let component: RobotComponent;
  let fixture: ComponentFixture<RobotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[FormsModule,HttpModule,RouterModule.forRoot(routes)],
      declarations: [ RobotComponent ],
      providers:[RobotService,{provide: APP_BASE_HREF, useValue : '/' }]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RobotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});


