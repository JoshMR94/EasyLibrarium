import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministrarUsuariosProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministrarUsuariosProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministrarUsuariosProvider Provider');
  }

  public getUsers(){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/users/').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
