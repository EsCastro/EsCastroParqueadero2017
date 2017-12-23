import { RouterModule, Routes } from '@angular/router';
import {IngresoComponent} from './components/ingreso/ingreso.component';
import {ConsultaComponent} from './components/consulta/consulta.component';
import {SalidaComponent} from './components/salida/salida.component';

const APP_ROUTES: Routes = [
  { path: 'ingreso', component: IngresoComponent },
  { path: 'consulta', component: ConsultaComponent },
  { path: 'salida', component: SalidaComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'ingreso' }
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES, {useHash:true});
