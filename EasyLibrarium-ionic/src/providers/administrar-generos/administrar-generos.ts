import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministrarGenerosProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministrarGenerosProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministrarGenerosProvider Provider');
  }

  public getGenres(){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/genres/').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
