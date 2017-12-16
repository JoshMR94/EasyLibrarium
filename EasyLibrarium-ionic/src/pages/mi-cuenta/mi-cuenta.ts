import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';

import { MiCuentaProvider } from '../../providers/mi-cuenta/mi-cuenta';
import { Usuario } from './usuario';

@Component({
  selector: 'page-mi-cuenta',
  templateUrl: 'mi-cuenta.html'
})
export class MiCuentaPage {

  id: number;
  user: Usuario;

  constructor(public miCuentaProvider: MiCuentaProvider, private storage: Storage) {
    this.user = new Usuario();
    this.getMyUser();
  }

  updateMyUser(body: any){
    this.storage.get('id').then((id) => {
      this.miCuentaProvider.updateMyUser(id, body).then(data => {
        console.log(this.user);
        }
      )
    });
  }

  getMyUser(){
    this.storage.get('id').then((id) => {
      this.miCuentaProvider.getMyUser(id).then(data => {
        this.user.username = data["username"];
        this.user.description = data["description"];
        this.user.password = data["password"];
        this.user.email = data["email"];
        }
      )
    });
  }
}
