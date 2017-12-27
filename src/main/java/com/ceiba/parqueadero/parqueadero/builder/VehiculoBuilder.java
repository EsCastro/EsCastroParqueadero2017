package com.ceiba.parqueadero.parqueadero.builder;

import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;

public class VehiculoBuilder {
	
	private VehiculoBuilder(){}
	
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getPlaca(), vehiculoEntity.getFechaIngreso(), vehiculoEntity.getFechaSalida(), vehiculoEntity.getCilindraje());
		}
		return vehiculo;
	}

}
