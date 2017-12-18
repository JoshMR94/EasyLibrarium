import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the RegistroProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class RegistroProvider {

  constructor(public http: HttpClient) {
    console.log('Hello RegistroProvider Provider');
  }

  insertUser(user: any){
    return new Promise(resolve => {
      this.http.post('http://localhost:8081/EasyLibrarium-web/webresources/users/user/insert', user).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
