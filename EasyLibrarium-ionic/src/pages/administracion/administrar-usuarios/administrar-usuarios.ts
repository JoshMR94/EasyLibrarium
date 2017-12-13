import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { AdministrarUsuariosProvider } from '../../../providers/administrar-usuarios/administrar-usuarios';
import { AdministraUsuarioPage } from './administra-usuario/administra-usuario';

@Component({
  selector: 'page-administrar-usuarios',
  templateUrl: 'administrar-usuarios.html'
})
export class AdministrarUsuariosPage {

  users: any;

  constructor(public administrarUsuariosProvider: AdministrarUsuariosProvider, public navCtrl: NavController,
      public navParams: NavParams) {
    this.getUsers();
  }

  getUsers(){
    this.administrarUsuariosProvider.getUsers().then(data => {
      this.users = data;
      console.log(this.users);
    });
  }

  administraUsuario(event, user) {
    this.navCtrl.push(AdministraUsuarioPage, {
      user: user
    });
  }

}
