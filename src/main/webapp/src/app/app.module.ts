import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
//Rutas
import {APP_ROUTING} from './app.routes';
//import {HttpClientModule} from '@angular/common/http';

//Services
import {VehiculosService} from './services/vehiculos.service';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { IngresoComponent } from './components/ingreso/ingreso.component';
import { ConsultaComponent } from './components/consulta/consulta.component';
import { SalidaComponent } from './components/salida/salida.component';
import { TipovehiculoPipe } from './pipes/tipovehiculo.pipe';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IngresoComponent,
    ConsultaComponent,
    SalidaComponent,
    TipovehiculoPipe
  ],
  imports: [
    BrowserModule,
    APP_ROUTING,
    FormsModule,
    HttpModule
    //HttpClientModule
  ],
  providers: [
    VehiculosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
