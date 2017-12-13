import { Component } from '@angular/core';
import { NavParams, NavController } from 'ionic-angular';

import { AdministraUsuarioProvider } from '../../../../providers/administra-usuario/administra-usuario';

@Component({
  selector: 'page-administra-usuario',
  templateUrl: 'administra-usuario.html'
})
export class AdministraUsuarioPage {

  user: any;

  constructor(public administraUsuarioProvider: AdministraUsuarioProvider, navParams: NavParams, public navCtrl: NavController) {
    this.user = navParams.get('user');
  }

  updateUser(id: number, body: any){
    this.administraUsuarioProvider.updateUser(id, body).then(data => {
      console.log(this.user);
      }
    )
  }

  deleteUser(id: number){
    this.administraUsuarioProvider.deleteUser(id);
    this.navCtrl.pop();
    this.navCtrl.pop();
  }
  
}
