import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { LoginPage } from '../pages/login/login';
import { NoticiasPage } from '../pages/noticias/noticias';
import { MisLibrosPage } from '../pages/mis-libros/mis-libros';
import { MisAutoresPage } from '../pages/mis-autores/mis-autores';
import { MiCuentaPage } from '../pages/mi-cuenta/mi-cuenta';
import { AdministracionPage } from '../pages/administracion/administracion'

import { ItemDetailsPage } from '../pages/item-details/item-details';
import { ListPage } from '../pages/list/list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    NoticiasPage,
    MisLibrosPage,
    MisAutoresPage,
    MiCuentaPage,
    AdministracionPage,
    ItemDetailsPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginPage,
    NoticiasPage,
    MisLibrosPage,
    MisAutoresPage,
    MiCuentaPage,
    AdministracionPage,
    ItemDetailsPage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
