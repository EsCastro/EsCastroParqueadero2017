package com.ceiba.parqueadero.parqueadero.builder;

import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;

public class VehiculoBuilder {
	
	private VehiculoBuilder(){}
	
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), vehiculoEntity.getFechaIngreso(), vehiculoEntity.getFechaSalida());
		}
		return vehiculo;
	}
	
	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setFechaIngreso(vehiculo.getFechaIngreso());
		vehiculoEntity.setFechaSalida(vehiculo.getFechaSalida());

		return vehiculoEntity;
	}	

}