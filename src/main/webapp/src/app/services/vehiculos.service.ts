import { Injectable } from '@angular/core';
//import {HttpClient} from '@angular/common/http';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {VehiculoEntity} from "../interfaces/vehiculo.interface";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

@Injectable()
export class VehiculosService {

  vehiculos: any[] = [];
  urlConsultVehi: string = 'http://localhost:8085/';
  urlIngresoVehi: string = 'http://localhost:8085/';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private http: Http) {
    console.log('Servicio listo!!');
  }

  getVehiculos(){
    let url = `vehiculos`;
    //let headers = this.getHeaders();

    return this.http.get(this.urlConsultVehi+url,this.options).map((respuesta: Response) => respuesta.json())
           .catch(this.errorHandler);

    /*return this.http.get(url).map((resp:any) => {
      this.vehiculos = resp.artists.items;
      return this.vehiculos;
    });*/
  }

  getVehiculo(placa:string){
    let url = `salidaVehiculo/`;
    return this.http.get(this.urlConsultVehi+url+placa,this.options).map((respuesta: Response) => respuesta.json())
           .catch(this.errorHandler);
  }

  deleteVehiculo(placa:string){
    let url = `liberarCupo/`;
    return this.http.delete(this.urlConsultVehi+url+placa,this.options).map((respuesta: Response) => respuesta.json())
           .catch(this.errorHandler);
  }

  createVehiculo(vehiculoEntity:VehiculoEntity){
    let url = `ingresarVehiculo`;
    return this.http.post(this.urlConsultVehi+url,JSON.stringify(vehiculoEntity),this.options)
                    .map((respuesta: Response) => respuesta.json());
                    //.catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }

  /*ingresarVehiculo(vehiculo:VehiculoEntity){
    //let body = JSON.stringify(vehiculo);
    let url = `ingresarVehiculo`;
    console.log('El vehiculo que se va a enviar tiene: ' + vehiculo.placa);
    return this.http.post(url, {"placa":'PPA25D',"tipoVehiculo":1,"cilindraje":100,"fechaIngreso":null,"fechaSalida":null})
                    .subscribe(res => {
                      console.log(res);
                    },
                    err => {
                      console.log("Error");
                    });
  }*/

}
