import { Component, OnInit } from '@angular/core';
import {VehiculoEntity} from "../../interfaces/vehiculo.interface";
import {VehiculosService} from '../../services/vehiculos.service';
import {RespuestaError} from "../../interfaces/respuesta.interface";
import {Router} from '@angular/router';

@Component({
  selector: 'app-salida',
  templateUrl: './salida.component.html',
  styleUrls: ['./salida.component.css']
})
export class SalidaComponent implements OnInit {

  vehiculo:VehiculoEntity = null;
  respuestaError:RespuestaError={
    errorCode:"",
    errorMessage:""
  };

  constructor(public _vehiculoService: VehiculosService, private _router:Router) { }

  ngOnInit() {
  }

  buscarVehiculo(placa:string){
    this.respuestaError ={
      errorCode:"",
      errorMessage:""
    };
    this._vehiculoService.getVehiculo(placa).subscribe((vehiculo) => {
      this.vehiculo = vehiculo;
    }, (error)=>{
      console.log(error);
      this.respuestaError = error.json();
    })
  }

  salidaVehiculo(){
    console.log('va a salir vehiculo placa: ' + this.vehiculo.placa);
    this._vehiculoService.deleteVehiculo(this.vehiculo.placa).subscribe((resultado) =>{
      console.log(resultado);
      this._router.navigate(['/consulta']);
    },(error) => {
      console.log(error);
      this._router.navigate(['/consulta']);
    });
  }

}
