package com.ceiba.parqueadero.parqueadero.service;

import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;

public interface VehiculoService {
	Iterable<VehiculoEntity> listaVehiculos();
	Vehiculo getVehiculoByPlaca(String placa);
	Vehiculo saveVehiculo(VehiculoEntity vehiculoEntity);
	void deleteVehiculo(String placa);
}
