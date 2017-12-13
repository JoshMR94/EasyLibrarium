import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { AdministrarGenerosProvider } from '../../../providers/administrar-generos/administrar-generos';
import { AdministraGeneroPage } from './administra-genero/administra-genero';

@Component({
  selector: 'page-administrar-generos',
  templateUrl: 'administrar-generos.html'
})
export class AdministrarGenerosPage {

  genres: any;

  constructor(public administrarGenerosProvider: AdministrarGenerosProvider, public navCtrl: NavController,
      public navParams: NavParams) {
    this.getGenres();   
  }

  getGenres(){
    this.administrarGenerosProvider.getGenres().then(data => {
      this.genres = data;
      console.log(this.genres);
    });
  }

  administraGenero(event, genre) {
    this.navCtrl.push(AdministraGeneroPage, {
      genre: genre
    });
  }
}
