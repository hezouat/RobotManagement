import {async, ComponentFixture, TestBed} from "@angular/core/testing";
import {RobotComponent} from "./robot.component";
import { Router } from "@angular/router";
import { Robot } from "../robot";
import { RobotService } from "../robot.service";


describe('RobotComponent', () => {
  let component: RobotComponent;
  let fixture: ComponentFixture<RobotComponent>;


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RobotComponent ]
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


