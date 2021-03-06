import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministrarAutoresProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministrarAutoresProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministrarAutoresProvider Provider');
  }

  public getAuthors(){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/authors/').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
