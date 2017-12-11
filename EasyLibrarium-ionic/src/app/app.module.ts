import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { LoginPage } from '../pages/login/login';
import { NoticiasPage } from '../pages/noticias/noticias';
import { MisLibrosPage } from '../pages/mis-libros/mis-libros';
import { MisAutoresPage } from '../pages/mis-autores/mis-autores';
import { MiCuentaPage } from '../pages/mi-cuenta/mi-cuenta';
import { AdministracionPage } from '../pages/administracion/administracion';
import { AdministrarLibrosPage } from '../pages/administracion/administrar-libros/administrar-libros';
import { AdministrarAutoresPage } from '../pages/administracion/administrar-autores/administrar-autores';
import { AdministrarUsuariosPage } from '../pages/administracion/administrar-usuarios/administrar-usuarios';
import { AdministrarGenerosPage } from '../pages/administracion/administrar-generos/administrar-generos';

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
    AdministrarLibrosPage,
    AdministrarAutoresPage,
    AdministrarUsuariosPage,
    AdministrarGenerosPage,
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
    AdministrarLibrosPage,
    AdministrarAutoresPage,
    AdministrarUsuariosPage,
    AdministrarGenerosPage,
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
