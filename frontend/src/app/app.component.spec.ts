import {TestBed, async} from "@angular/core/testing";
import {AppComponent} from "./app.component";
import { Renderer,NgModule } from '@angular/core';
import { Router, RouterOutlet } from "@angular/router";
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Robot} from "./robot";
import { RobotService } from "./robot.service";
import {APP_BASE_HREF} from "@angular/common";

describe('AppComponent', () => {

  beforeEach(() => TestBed.configureTestingModule({
    imports:[FormsModule, HttpModule],
    declarations: [  ],
    providers: [
      Renderer,
      RobotService,
      NgModule,
      {provide: APP_BASE_HREF, useValue : '/' },
      RouterOutlet
    ]}));

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

});
