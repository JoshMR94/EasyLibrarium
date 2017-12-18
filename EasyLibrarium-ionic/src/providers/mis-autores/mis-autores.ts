import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the MisAutoresProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class MisAutoresProvider {

  constructor(public http: HttpClient) {
    console.log('Hello MisAutoresProvider Provider');
  }

  public getAuthorsByIdUser(id:number){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/users/user/'+id).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
