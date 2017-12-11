import { Component } from '@angular/core';

import { AdministrarLibrosProvider } from '../../../providers/administrar-libros/administrar-libros';

@Component({
  selector: 'page-administrar-libros',
  templateUrl: 'administrar-libros.html'
})
export class AdministrarLibrosPage {

  books: any;

  constructor(public administrarLibrosProvider: AdministrarLibrosProvider) {
    this.getBooks();
  }

  getBooks(){
    this.administrarLibrosProvider.getBooks().then(data => {
      this.books = data;
      console.log(this.books);
    });
  }

}
