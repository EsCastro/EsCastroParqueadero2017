package com.ceiba.parqueadero.parqueadero.dto;

import java.util.Date;

public class Moto extends Vehiculo{
	private int cilindraje;
	
	public Moto(int tipoVehiculo, String placa, Date fechaIngreso, Date fechaSalida, int cilindraje) {
		super(tipoVehiculo, placa, fechaIngreso, fechaSalida, cilindraje);
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
}
