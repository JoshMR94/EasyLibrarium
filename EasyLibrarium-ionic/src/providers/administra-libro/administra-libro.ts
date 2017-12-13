import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministraLibroProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministraLibroProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministraLibroProvider Provider');
  }

  public updateBook(id: number, body: any){
    return new Promise(resolve => {
      this.http.put('http://localhost:8081/EasyLibrarium-web/webresources/books/book/'+id+'/update', body).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
