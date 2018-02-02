import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Storage } from '@ionic/storage';

import { NoticiasPage } from '../noticias/noticias';
import { RegistroPage } from './registro/registro';

import { LoginProvider } from '../../providers/login/login';


@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  rootPage = NoticiasPage;

  username: String;
  password: String;

  user: any;

  usernameC: any;
  userTypeC: any;

  constructor(public loginProvider: LoginProvider, public navCtrl: NavController, private storage: Storage) {
  }

  getUserCredentials(username, password){
    this.loginProvider.getUsersCredentials(username, password).then(data => {
      this.user = data;
      if(this.user != ""){
        this.storage.set('userType', this.user.userType);
        this.storage.set('username', this.user.username);
        this.storage.set('id', this.user.id);
        this.setUserCredentials();
        this.navCtrl.setRoot(NoticiasPage);
      } 
      console.log(this.user);
    });
  }

  getUserCredentiaslFromFacebook(){
    this.loginProvider.getUsersCredentialsFromFacebook().then(data => {
      this.user = data;
      if(this.user != ""){
        this.storage.set('userType', this.user.userType);
        this.storage.set('username', this.user.username);
        this.storage.set('id', this.user.id);
        this.setUserCredentials();
        this.navCtrl.setRoot(NoticiasPage);
      } 
      console.log(this.user);
    });
  }

  setUserCredentials(){
    this.storage.get('userType').then((val) => {
      this.userTypeC = val;
    });

    this.storage.get('username').then((val) => {
      this.usernameC = val;
    });
  }

  irRegistro(){
    this.navCtrl.push(RegistroPage)
  }


}
