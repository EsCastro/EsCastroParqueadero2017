package com.ceiba.parqueadero.parqueadero.dto;

import java.util.Date;

public class Carro extends Vehiculo{

	public Carro(int tipoVehiculo, String placa, Date fechaIngreso, Date fechaSalida, int cilindraje) {
		super(tipoVehiculo, placa, fechaIngreso, fechaSalida, cilindraje);
	}


}
