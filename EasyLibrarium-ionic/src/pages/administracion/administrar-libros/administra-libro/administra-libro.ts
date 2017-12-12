import { Component } from '@angular/core';
import { NavParams } from 'ionic-angular';

@Component({
  selector: 'page-administra-libro',
  templateUrl: 'administra-libro.html'
})
export class AdministraLibroPage {

  book: any;

  constructor(public navParams: NavParams) {
    this.book = navParams.get('book');
  }
}
