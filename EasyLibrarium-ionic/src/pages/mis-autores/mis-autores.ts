import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';

import { Autor } from './autor';
import { Libro } from './libro';
import { MisAutoresProvider } from '../../providers/mis-autores/mis-autores';


@Component({
  selector: 'page-mis-autores',
  templateUrl: 'mis-autores.html'
})
export class MisAutoresPage {

  userAuthors: Autor[];
  books: Libro[];
  

  constructor(public misAutoresProvider: MisAutoresProvider, private storage: Storage) {
    this.userAuthors = new Array<Autor>();
    this.books = new Array<Libro>();
  }

  ngOnInit(){
    this.storage.get('id').then((id) => {
      this.getAuthorsByIdUser(id);
    });
  }

  getAuthorsByIdUser(id){
    this.misAutoresProvider.getAuthorsByIdUser(id).then(data => {

      this.books = data["books"];

      //extracting authors from books of the user

      for (let i = 0; i < this.books.length; i++) {
        let autores: Autor[] = this.books[i].authors;
        for(let j = 0; j < autores.length; j++){
          this.userAuthors.push(autores[j]);
        }
      }

      console.log(this.userAuthors);
    });
  }

  
}
