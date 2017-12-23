package com.ceiba.parqueadero.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.parqueadero.Exeptions.ResourceNotFoundException;
import com.ceiba.parqueadero.parqueadero.builder.VehiculoBuilder;
import com.ceiba.parqueadero.parqueadero.dto.Parqueadero;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;


import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.util.Iterator;


@RestController
@CrossOrigin(origins="http://localhost:8085",allowedHeaders="*")
public class VigilanteController {
	@Autowired
	private VehiculoService vehiculoService;
	
	/**
	 * Ingresa vehiculo al parqueadero
	 * @param vehiculoEntity, recibe el objeto con el vehiculo a ingresar
	 * @return, vehiculo ingresado al parqueadero
	 */
	//@RequestMapping(value = "ingresarVehiculo", method = RequestMethod.POST)
	@PostMapping("ingresarVehiculo")
	public Vehiculo ingresarVehiculo(@RequestBody VehiculoEntity vehiculoEntity){
		System.out.println("Llego a crear un vehiculo con: " + vehiculoEntity.getPlaca() + " tip "+ vehiculoEntity.getTipoVehiculo() + " cilin " + vehiculoEntity.getCilindraje());
		Parqueadero parqueadero = new Parqueadero();
		Vehiculo vehiculo = VehiculoBuilder.convertirADominio(vehiculoEntity);
		
		//Valida si hay cupo disponible
		if(!parqueadero.placaAutorizada(vehiculo.getPlaca())){
			throw new ResourceNotFoundException(5, ERROR_DIA_HABIL);
		}else if(!parqueadero.cupoDisponible(vehiculo.getTipoVehiculo())){
			if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
				throw new ResourceNotFoundException(5, ERROR_CUPO_MAX_CARRO);
			}else{
				throw new ResourceNotFoundException(5, ERROR_CUPO_MAX_MOTO);
			}			
			//return null;
		}else if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			CUPO_USO_CARROS++;
			return vehiculoService.saveVehiculo(vehiculoEntity);
		}else{
			CUPO_USO_MOTOS++;
			return vehiculoService.saveVehiculo(vehiculoEntity);
		}
	}

	/**
	 * Ingresa vehiculo al parqueadero
	 * @param vehiculoEntity, recibe el objeto con el vehiculo a ingresar
	 * @return, vehiculo ingresado al parqueadero
	 * @throws ParseException 
	 */
	@RequestMapping(value = "salidaVehiculo/{placa}", method = RequestMethod.GET)
	public Vehiculo salidaVehiculo(@PathVariable String placa) throws ParseException{
		Vehiculo vehiculo = vehiculoService.getVehiculoByPlaca(placa);
		Parqueadero parqueadero = new Parqueadero();
		return parqueadero.totalPagar(vehiculo);
	}
	
	/**
	 * Se consultan todos los vehiculos que se tienen en el parqueadero
	 * @return Objetos de vehiculos en el parqueadero.
	 */
	@RequestMapping(value = "vehiculos", method = RequestMethod.GET)
	public Iterable<VehiculoEntity> consultarVehiculos(){
		return vehiculoService.listaVehiculos();
	}
	
	/**
	 * Se elimina el registro del vehiculo del parqueadero
	 * @return
	 */
	//@RequestMapping(value = "liberarCupo", method = RequestMethod.DELETE)
	@DeleteMapping("liberarCupo/{placa}")
	public void liberarCupo(@PathVariable String placa){
		System.out.println("liberarCupo **** " + placa);
		Vehiculo vehiculo = vehiculoService.getVehiculoByPlaca(placa);
		System.out.println("Traigo Vehiculo **** " + vehiculo.getPlaca());
		
		if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			CUPO_USO_CARROS--;		
		}else{
			CUPO_USO_MOTOS--;
		}		
		vehiculoService.deleteVehiculo(placa);
	}	
}