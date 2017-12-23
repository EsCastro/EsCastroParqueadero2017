import { Component, OnInit } from '@angular/core';
import {VehiculoEntity} from "../../interfaces/vehiculo.interface";
import {VehiculosService} from '../../services/vehiculos.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-salida',
  templateUrl: './salida.component.html',
  styleUrls: ['./salida.component.css']
})
export class SalidaComponent implements OnInit {

  vehiculo:VehiculoEntity = null;

  constructor(public _vehiculoService: VehiculosService, private _router:Router) { }

  ngOnInit() {
  }

  buscarVehiculo(placa:string){
    this._vehiculoService.getVehiculo(placa).subscribe((vehiculo) => {
      this.vehiculo = vehiculo;
    }, (error)=>{
      console.log(error);
    })
  }

  salidaVehiculo(){
    console.log('va a salir vehiculo placa: ' + this.vehiculo.placa)
    this._vehiculoService.deleteVehiculo(this.vehiculo.placa).subscribe((resultado) =>{
      console.log(resultado);
      this._router.navigate(['/consulta']);
    },(error) => {
      console.log(error);
    });
  }

}
