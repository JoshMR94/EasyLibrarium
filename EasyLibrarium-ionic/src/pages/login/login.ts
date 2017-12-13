import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { LoginProvider } from '../../providers/login/login';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  username: String;
  password: String;

  user: any;

  constructor(public loginProvider: LoginProvider, public navCtrl: NavController) {
  }

  getUserCredentials(username, password){
    this.loginProvider.getUsersCredentials(username, password).then(data => {
      this.user = data;
      console.log(this.user);
    });
  }
}
