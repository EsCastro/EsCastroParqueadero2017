package com.ceiba.parqueadero.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;

@RestController
public class VehiculoController {
	@Autowired
	VehiculoService vehiculoService;
	
	@RequestMapping(value = "vehiculo", method = RequestMethod.POST)
	public Vehiculo saveVehiculo(VehiculoEntity vehiculoEntity){
		System.out.println("**********Fecha Ingreso: " + vehiculoEntity.getFechaIngreso());
		return vehiculoService.saveVehiculo(vehiculoEntity);
	}

}
