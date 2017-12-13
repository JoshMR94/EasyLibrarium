import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministraAutorProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministraAutorProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministraAutorProvider Provider');
  }

  public updateAuthor(id: number, body: any){
    return new Promise(resolve => {
      this.http.put('http://localhost:8081/EasyLibrarium-web/webresources/authors/author/'+id+'/update', body).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  public deleteAuthor(id:number){
    return new Promise(resolve => {
      this.http.delete('http://localhost:8081/EasyLibrarium-web/webresources/authors/author/'+id+'/delete').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
