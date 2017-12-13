import { Component } from '@angular/core';
import { NavParams, NavController } from 'ionic-angular';

import { AdministraLibroProvider } from '../../../../providers/administra-libro/administra-libro';

@Component({
  selector: 'page-administra-libro',
  templateUrl: 'administra-libro.html'
})
export class AdministraLibroPage {

  book: any;

  constructor(public administraLibroProvider: AdministraLibroProvider, navParams: NavParams, public navCtrl: NavController) {
    this.book = navParams.get('book');
  }

  updateBook(id: number, body: any){
    this.administraLibroProvider.updateBook(id, body).then(data => {
      console.log(this.book);
      }
    )
  }

  deleteBook(id: number){
    this.administraLibroProvider.deleteBook(id);
    this.navCtrl.pop();
    this.navCtrl.pop();
  }
  
}
