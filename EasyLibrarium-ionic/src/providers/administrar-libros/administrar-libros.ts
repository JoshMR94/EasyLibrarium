import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministrarLibrosProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministrarLibrosProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministrarLibrosProvider Provider');
  }

  public getBooks(){
    return new Promise(resolve => {
      this.http.get('http://localhost:8081/EasyLibrarium-web/webresources/books/').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
