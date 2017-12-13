import { Injectable } from "@angular/core";
import { Headers, Http } from "@angular/http";
import "rxjs/add/operator/toPromise";
import { Robot } from "./robot"

@Injectable()
export class RobotService {

  constructor(private http: Http) {

  }

  private headers = new Headers({'Content-Type': 'application/json'});
  private robotsUrl = '/rest/robots';

  getRobots(): Promise<Robot[]> {
    return this.http.get(this.robotsUrl + "/allRobots")
      .toPromise()
      .then(response => response.json() as Robot[])
      .catch(this.handleError);
  }


  getRobot(id: number): Promise<Robot> {
    const url = `${this.robotsUrl}/getRobot/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Robot)
      .catch(this.handleError);
  }


  createRobot(robot: Robot): Promise<Robot> {
    return this.http
      .post(this.robotsUrl + "/createRobot", JSON.stringify(robot), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Robot)
      .catch(this.handleError);
  }


  deleteRobot(robot: Robot): Promise<void> {
    const url = `${this.robotsUrl}/deleteRobot/${robot.id}`;
    return this.http.get(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
