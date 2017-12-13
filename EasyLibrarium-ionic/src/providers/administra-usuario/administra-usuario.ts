import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministraUsuarioProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministraUsuarioProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministraUsuarioProvider Provider');
  }

  public updateUser(id: number, body: any){
    return new Promise(resolve => {
      this.http.put('http://localhost:8081/EasyLibrarium-web/webresources/users/user/'+id+'/update', body).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  public deleteUser(id:number){
    return new Promise(resolve => {
      this.http.delete('http://localhost:8081/EasyLibrarium-web/webresources/users/user/'+id+'/delete').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
