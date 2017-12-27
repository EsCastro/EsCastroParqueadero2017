import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {VehiculoEntity} from "../../interfaces/vehiculo.interface";
import {VehiculosService} from '../../services/vehiculos.service';
import {RespuestaError} from "../../interfaces/respuesta.interface";
import {Router} from '@angular/router';
import "rxjs/Rx";

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html'
})
export class IngresoComponent implements OnInit {

  vehiculo:VehiculoEntity = {
    placa:"",
    cilindraje:0,
    tipoVehiculo:1,
    fechaIngreso:null,
    fechaSalida:null,
    valorPagar:null
  };

  respuestaError:RespuestaError={
    errorCode:"",
    errorMessage:""
  };

  constructor(public _vehiculoService: VehiculosService, private _router:Router) { }

  ngOnInit() {
  }

  ingresarVehiculo(){
        this._vehiculoService.createVehiculo(this.vehiculo).subscribe((vehiculo)=>{
        this._router.navigate(['/consulta']);
      },(error)=>{
        this.respuestaError = error.json();
      });
  }

}
