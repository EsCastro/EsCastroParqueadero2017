package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import com.ceiba.parqueadero.parqueadero.exeptions.ResourceNotFoundException;

public class Vigilante {

	public boolean validaVehiculo(Vehiculo vehiculo){
		boolean ban = true;
		Parqueadero parqueadero = new Parqueadero();
		
		if(!parqueadero.placaAutorizada(vehiculo.getPlaca())){
			throw new ResourceNotFoundException(5, ERROR_DIA_HABIL);
		}else if(!parqueadero.cupoDisponible(vehiculo.getTipoVehiculo())){
			if(vehiculo.getTipoVehiculo() == TIPO_CARRO){				
				throw new ResourceNotFoundException(5, ERROR_CUPO_MAX_CARRO);
			}else{
				throw new ResourceNotFoundException(5, ERROR_CUPO_MAX_MOTO);
			}			
		}		
		return ban;
	}
}
