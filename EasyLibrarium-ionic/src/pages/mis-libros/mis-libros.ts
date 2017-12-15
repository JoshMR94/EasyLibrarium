import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';

import { Usuario } from './usuario';
import { MisLibrosProvider } from '../../providers/mis-libros/mis-libros';


@Component({
  selector: 'page-mis-libros',
  templateUrl: 'mis-libros.html'
})
export class MisLibrosPage implements OnInit {

  user: Usuario;
  books: any;

  constructor(public misLibrosProvider: MisLibrosProvider, private storage: Storage) {
    this.user = new Usuario();
  }

  ngOnInit(){
    this.storage.get('id').then((id) => {
      this.getBooksByIdUser(id);
    });
  }

  getBooksByIdUser(id){
    this.misLibrosProvider.getBooksByIdUser(id).then(data => {
      /*
      for(var x in data){
        console.log(data[x]);
        console.log(typeof data[x]);
      }
      */
      this.books = data["books"];
      
      //this.user = new User(data[0]);
      //console.log(typeof data[x]);
      // this.user.email = data[0].email;
      //console.log("User es de tipo: " + typeof this.user);
    });
  }
}
