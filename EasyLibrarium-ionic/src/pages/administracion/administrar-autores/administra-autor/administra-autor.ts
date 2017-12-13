import { Component } from '@angular/core';
import { NavParams, NavController } from 'ionic-angular';

import { AdministraAutorProvider } from '../../../../providers/administra-autor/administra-autor';

@Component({
  selector: 'page-administra-autor',
  templateUrl: 'administra-autor.html'
})
export class AdministraAutorPage {

  author: any;

  constructor(public administraAutorProvider: AdministraAutorProvider, navParams: NavParams, public navCtrl: NavController) {
    this.author = navParams.get('author');
  }

  updateAuthor(id: number, body: any){
    this.administraAutorProvider.updateAuthor(id, body).then(data => {
      console.log(this.author);
      }
    )
  }

  deleteAuthor(id: number){
    this.administraAutorProvider.deleteAuthor(id);
    this.navCtrl.pop();
    this.navCtrl.pop();
  }
  
}
