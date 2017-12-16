import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the MiCuentaProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class MiCuentaProvider {

  constructor(public http: HttpClient) {
    console.log('Hello MiCuentaProvider Provider');
  }

  public updateMyUser(id: number, body: any){
    return new Promise(resolve => {
      this.http.put('http://localhost:8081/EasyLibrarium-web/webresources/users/user/'+id+'/update', body).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  public getMyUser(id: number){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/users/user/'+id).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
