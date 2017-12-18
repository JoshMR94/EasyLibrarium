import { Component } from '@angular/core';

import { Usuario } from './usuario';

import { RegistroProvider } from '../../../providers/registro/registro';


@Component({
  selector: 'page-registro',
  templateUrl: 'registro.html'
})
export class RegistroPage {

  user: Usuario;

  constructor(public registroProvider: RegistroProvider) {
    this.user = new Usuario();
  }

  insertUser(){
    this.user.userType = "USER";
    this.registroProvider.insertUser(this.user);
  }
}
