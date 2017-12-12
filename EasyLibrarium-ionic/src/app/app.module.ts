import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { HttpClientModule } from '@angular/common/http';
import { MyApp } from './app.component';

import { LoginPage } from '../pages/login/login';
import { NoticiasPage } from '../pages/noticias/noticias';
import { MisLibrosPage } from '../pages/mis-libros/mis-libros';
import { MisAutoresPage } from '../pages/mis-autores/mis-autores';
import { MiCuentaPage } from '../pages/mi-cuenta/mi-cuenta';
import { AdministracionPage } from '../pages/administracion/administracion';
import { AdministrarLibrosPage } from '../pages/administracion/administrar-libros/administrar-libros';
import { AdministraLibroPage } from '../pages/administracion/administrar-libros/administra-libro/administra-libro';
import { AdministrarAutoresPage } from '../pages/administracion/administrar-autores/administrar-autores';
import { AdministrarUsuariosPage } from '../pages/administracion/administrar-usuarios/administrar-usuarios';
import { AdministrarGenerosPage } from '../pages/administracion/administrar-generos/administrar-generos';

import { ItemDetailsPage } from '../pages/item-details/item-details';
import { ListPage } from '../pages/list/list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AdministrarLibrosProvider } from '../providers/administrar-libros/administrar-libros';

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
    AdministraLibroPage,
    AdministrarAutoresPage,
    AdministrarUsuariosPage,
    AdministrarGenerosPage,
    ItemDetailsPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
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
    AdministraLibroPage,
    AdministrarAutoresPage,
    AdministrarUsuariosPage,
    AdministrarGenerosPage,
    ItemDetailsPage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AdministrarLibrosProvider
  ]
})
export class AppModule {}
