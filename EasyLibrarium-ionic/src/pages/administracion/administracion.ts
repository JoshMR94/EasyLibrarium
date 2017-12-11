import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { AdministrarLibrosPage } from './administrar-libros/administrar-libros';
import { AdministrarAutoresPage } from './administrar-autores/administrar-autores';
import { AdministrarUsuariosPage } from './administrar-usuarios/administrar-usuarios';
import { AdministrarGenerosPage } from './administrar-generos/administrar-generos';

@Component({
  selector: 'page-administracion',
  templateUrl: 'administracion.html'
})
export class AdministracionPage {
  constructor(public navCtrl: NavController) {
  }

  irAdministrarLibros(){
    this.navCtrl.push(AdministrarLibrosPage);
  }

  irAdministrarAutores(){
    this.navCtrl.push(AdministrarAutoresPage);
  }

  irAdministrarUsuarios(){
    this.navCtrl.push(AdministrarUsuariosPage);
  }

  irAdministrarGeneros(){
    this.navCtrl.push(AdministrarGenerosPage);
  }
}
