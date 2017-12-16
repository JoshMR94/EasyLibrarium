import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { HttpClientModule } from '@angular/common/http';
import { MyApp } from './app.component';
import { IonicStorageModule } from '@ionic/storage';

import { LoginPage } from '../pages/login/login';
import { NoticiasPage } from '../pages/noticias/noticias';
import { MisLibrosPage } from '../pages/mis-libros/mis-libros';
import { MisAutoresPage } from '../pages/mis-autores/mis-autores';
import { MiCuentaPage } from '../pages/mi-cuenta/mi-cuenta';
import { AdministracionPage } from '../pages/administracion/administracion';
import { AdministrarLibrosPage } from '../pages/administracion/administrar-libros/administrar-libros';
import { AdministraLibroPage } from '../pages/administracion/administrar-libros/administra-libro/administra-libro';
import { AdministrarAutoresPage } from '../pages/administracion/administrar-autores/administrar-autores';
import { AdministraAutorPage } from '../pages/administracion/administrar-autores/administra-autor/administra-autor';
import { AdministrarUsuariosPage } from '../pages/administracion/administrar-usuarios/administrar-usuarios';
import { AdministraUsuarioPage} from '../pages/administracion/administrar-usuarios/administra-usuario/administra-usuario';
import { AdministrarGenerosPage } from '../pages/administracion/administrar-generos/administrar-generos';
import { AdministraGeneroPage } from '../pages/administracion/administrar-generos/administra-genero/administra-genero';

import { ItemDetailsPage } from '../pages/item-details/item-details';
import { ListPage } from '../pages/list/list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { AdministrarLibrosProvider } from '../providers/administrar-libros/administrar-libros';
import { AdministraLibroProvider } from '../providers/administra-libro/administra-libro';
import { AdministrarAutoresProvider } from '../providers/administrar-autores/administrar-autores';
import { AdministraAutorProvider } from '../providers/administra-autor/administra-autor';
import { AdministrarUsuariosProvider } from '../providers/administrar-usuarios/administrar-usuarios';
import { AdministraUsuarioProvider } from '../providers/administra-usuario/administra-usuario';
import { AdministrarGenerosProvider } from '../providers/administrar-generos/administrar-generos';
import { AdministraGeneroProvider } from '../providers/administra-genero/administra-genero';
import { LoginProvider } from '../providers/login/login';
import { MisLibrosProvider } from '../providers/mis-libros/mis-libros';
import { MiCuentaProvider } from '../providers/mi-cuenta/mi-cuenta';

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
    AdministraAutorPage,
    AdministrarUsuariosPage,
    AdministraUsuarioPage,
    AdministrarGenerosPage,
    AdministraGeneroPage,
    ItemDetailsPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot() //storage here
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
    AdministraAutorPage,
    AdministrarUsuariosPage,
    AdministraUsuarioPage,
    AdministrarGenerosPage,
    AdministraGeneroPage,
    ItemDetailsPage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AdministrarLibrosProvider,
    AdministraLibroProvider,
    AdministrarAutoresProvider,
    AdministraAutorProvider,
    AdministrarUsuariosProvider,
    AdministraUsuarioProvider,
    AdministrarGenerosProvider,
    AdministraGeneroProvider,
    LoginProvider,
    MisLibrosProvider,
    MiCuentaProvider
  ]
})
export class AppModule {}
