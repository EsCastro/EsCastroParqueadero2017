import { Component, OnInit } from '@angular/core';
import {VehiculosService} from '../../services/vehiculos.service';
import {VehiculoEntity} from "../../interfaces/vehiculo.interface";

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html'
})
export class ConsultaComponent{
  private vehiculosEntity:VehiculoEntity[];

  constructor(public _vehiculoService: VehiculosService) {
     this._vehiculoService.getVehiculos().subscribe((vehiculosEntity) => {
       console.log(vehiculosEntity);
       this.vehiculosEntity = vehiculosEntity;
     },(error)=>{
       console.log(error);
     })

    /*  this._vehiculoService.getVehiculos().subscribe(respuesta => {
      console.log('informacion lista');
      console.log('Respuesta es:  '+ respuesta);
    });*/
  }
}
