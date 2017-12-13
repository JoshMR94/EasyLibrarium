import { Component } from '@angular/core';
import { NavParams, NavController } from 'ionic-angular';

import { AdministraGeneroProvider } from '../../../../providers/administra-genero/administra-genero';

@Component({
  selector: 'page-administra-genero',
  templateUrl: 'administra-genero.html'
})
export class AdministraGeneroPage {

  genre: any;

  constructor(public administraGeneroProvider: AdministraGeneroProvider, navParams: NavParams, public navCtrl: NavController) {
    this.genre = navParams.get('genre');
  }

  updateGenre(id: number, body: any){
    this.administraGeneroProvider.updateGenre(id, body).then(data => {
      console.log(this.genre);
      }
    )
  }

  deleteGenre(id: number){
    this.administraGeneroProvider.deleteGenre(id);
    this.navCtrl.pop();
    this.navCtrl.pop();
  }
  
}
