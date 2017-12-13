import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the AdministraGeneroProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AdministraGeneroProvider {

  constructor(public http: HttpClient) {
    console.log('Hello AdministraGeneroProvider Provider');
  }

  public updateGenre(id: number, body: any){
    return new Promise(resolve => {
      this.http.put('http://localhost:8081/EasyLibrarium-web/webresources/genres/genre/'+id+'/update', body).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  public deleteGenre(id:number){
    return new Promise(resolve => {
      this.http.delete('http://localhost:8081/EasyLibrarium-web/webresources/genres/genre/'+id+'/delete').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
