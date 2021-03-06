package com.ceiba.parqueadero.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.parqueadero.builder.VehiculoBuilder;
import com.ceiba.parqueadero.parqueadero.dto.Parqueadero;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.dto.Vigilante;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;


import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;

@RestController
//@CrossOrigin(origins="http://localhost:8085",allowedHeaders="*")
public class VigilanteController {
	@Autowired
	private VehiculoService vehiculoService;
	
	/**
	 * Ingresa vehiculo al parqueadero
	 * @param vehiculoEntity, recibe el objeto con el vehiculo a ingresar
	 * @return, vehiculo ingresado al parqueadero
	 */
	@RequestMapping(value = "ingresarVehiculo", method = RequestMethod.POST)
	//@PostMapping("ingresarVehiculo")
	public Vehiculo ingresarVehiculo(@RequestBody VehiculoEntity vehiculoEntity){		
		Vehiculo vehiculo = VehiculoBuilder.convertirADominio(vehiculoEntity);
		Vigilante vigilante = new Vigilante();
		
		if(vigilante.validaVehiculo(vehiculo))
			vehiculo = insertarVehiculo(vehiculoEntity);
		
		return vehiculo;
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
		vehiculo = parqueadero.totalPagar(vehiculo);
		
		return vehiculo;
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
		Vehiculo vehiculo = vehiculoService.getVehiculoByPlaca(placa);
		Parqueadero parqueadero = new Parqueadero();		
		parqueadero.liberarCupo(vehiculo);
				
		vehiculoService.deleteVehiculo(placa);
	}
	
	public Vehiculo insertarVehiculo(VehiculoEntity vehiculoEntity){
		Vehiculo vehiculo = VehiculoBuilder.convertirADominio(vehiculoEntity);
		vehiculoEntity.setPlaca(vehiculo.getPlaca().toUpperCase());
		if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			int cupoCarro = getCupoUsoCarros();
			setCupoUsoCarros(cupoCarro + 1);
			vehiculo = vehiculoService.saveVehiculo(vehiculoEntity);
			return (vehiculo != null)?vehiculo:null;
		}else {
			int cupoMoto = getCupoUsoMotos();
			setCupoUsoMotos(cupoMoto + 1);
			vehiculo = vehiculoService.saveVehiculo(vehiculoEntity);
			return (vehiculo != null)?vehiculo:null;
		}
	}	
}
