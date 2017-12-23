package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

public class Moto extends Vehiculo{	

	public Moto(int tipoVehiculo, String placa, int cilindraje, java.util.Date fechaIngreso,
			java.util.Date fechaSalida) {
		super(tipoVehiculo, placa, cilindraje, fechaIngreso, fechaSalida);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que me valida si una moto es de alto cilindraje
	 * @param cilindraje, cilindraje de la moto
	 * @return true si es de alto cilindraje, false si no es de alto cilindraje
	 */
	public boolean altoCilindraje(int cilindraje){
		boolean ban = false;
		
		if(cilindraje > ALTO_CILINDRAJE){
			ban = true;
		}
		return ban;
	}

}
