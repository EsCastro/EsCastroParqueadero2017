package com.ceiba.parqueadero.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.parqueadero.builder.VehiculoBuilder;
import com.ceiba.parqueadero.parqueadero.dao.VehiculoRespository;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;

import java.util.Date;

@Service
public class VehiculoServiceImp implements VehiculoService{
	@Autowired
	private VehiculoRespository vehiculoRespository;
	
	@Override
	public Iterable<VehiculoEntity> listaVehiculos() {
		return vehiculoRespository.findAll();
	}

	@Override
	public Vehiculo getVehiculoByPlaca(String placa) {
		VehiculoEntity vehiculo = vehiculoRespository.findOne(placa);
		return VehiculoBuilder.convertirADominio(vehiculo);
	}

	@Override
	public Vehiculo saveVehiculo(VehiculoEntity vehiculoEntity) {
		if(vehiculoEntity != null){
			vehiculoEntity.setFechaIngreso(new Date());
			return VehiculoBuilder.convertirADominio(vehiculoRespository.save(vehiculoEntity));
		}		
		return null;
	}

	@Override
	public void deleteVehiculo(String placa) {
		vehiculoRespository.delete(placa);
		
	}

}
