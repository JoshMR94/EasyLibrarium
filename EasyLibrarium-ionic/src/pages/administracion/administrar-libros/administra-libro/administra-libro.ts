import { Component } from '@angular/core';
import { NavParams } from 'ionic-angular';

import { AdministraLibroProvider } from '../../../../providers/administra-libro/administra-libro';

@Component({
  selector: 'page-administra-libro',
  templateUrl: 'administra-libro.html'
})
export class AdministraLibroPage {

  book: any;

  constructor(public administraLibroProvider: AdministraLibroProvider, navParams: NavParams) {
    this.book = navParams.get('book');
  }

  updateBook(id: number, body: any){
    this.administraLibroProvider.updateBook(id, body).then(data => {
      console.log(this.book);
      }
    )
  }
  
}
