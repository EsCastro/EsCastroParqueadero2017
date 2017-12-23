import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {VehiculoEntity} from "../../interfaces/vehiculo.interface";
import {VehiculosService} from '../../services/vehiculos.service';
import {Router} from '@angular/router';

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
  }

  constructor(public _vehiculoService: VehiculosService, private _router:Router) { }

  ngOnInit() {
  }

  ingresarVehiculo(){
     console.log(this.vehiculo);
      this._vehiculoService.createVehiculo(this.vehiculo).subscribe((vehiculo)=>{
        this._router.navigate(['/consulta']);
        console.log(vehiculo);
      },(error)=>{
        console.log(error);
      });
  }

}
