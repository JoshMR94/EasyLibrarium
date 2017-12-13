import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { AdministrarAutoresProvider } from '../../../providers/administrar-autores/administrar-autores';

import { AdministraAutorPage } from './administra-autor/administra-autor';

@Component({
  selector: 'page-administrar-autores',
  templateUrl: 'administrar-autores.html'
})
export class AdministrarAutoresPage {

  authors: any

  constructor(public administrarAutoresProvider: AdministrarAutoresProvider, public navCtrl: NavController,
      public navParams: NavParams) {
    this.getAuthors();
  }

  getAuthors(){
    this.administrarAutoresProvider.getAuthors().then(data => {
      this.authors = data;
      console.log(this.authors);
    });
  }

  administraAutor(event, author) {
    this.navCtrl.push(AdministraAutorPage, {
      author: author
    });
  }
}
