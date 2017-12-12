import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { AdministrarLibrosProvider } from '../../../providers/administrar-libros/administrar-libros';

import { AdministraLibroPage } from './administra-libro/administra-libro';

@Component({
  selector: 'page-administrar-libros',
  templateUrl: 'administrar-libros.html'
})
export class AdministrarLibrosPage {

  books: any;

  constructor(public administrarLibrosProvider: AdministrarLibrosProvider, public navCtrl: NavController,
     public navParams: NavParams) {
    this.getBooks();
  }

  getBooks(){
    this.administrarLibrosProvider.getBooks().then(data => {
      this.books = data;
      console.log(this.books);
    });
  }

  administraLibro(event, book) {
    this.navCtrl.push(AdministraLibroPage, {
      book: book
    });
  }

}
