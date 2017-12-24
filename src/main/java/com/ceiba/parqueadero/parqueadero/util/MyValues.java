package com.ceiba.parqueadero.parqueadero.util;

import java.util.Calendar;

public final class MyValues {
	public static final int CUPO_MOTOS = 10;
	public static final int CUPO_CARROS = 20;	
	public static final double VALOR_HORA_CARRO = 1000;
	public static final double VALOR_HORA_MOTO = 500;
	public static final double VALOR_DIA_CARRO = 8000;
	public static final double VALOR_DIA_MOTO = 4000;
	public static final double VALOR_ADICIONAL_CILINDRAJE = 2000;
	public static final int TIPO_CARRO = 1;
	public static final int TIPO_MOTO = 2;
	public static final int ALTO_CILINDRAJE = 500;
	public static final int LIMITE_VALOR_DIA = 9;
	public static final String INICIAL_PLACA_AUTORIZADA = "A";
	public static final String ERROR_CUPO_MAX_MOTO = "El cupo maximo para Motos es de " + CUPO_MOTOS + " puestos";
	public static final String ERROR_CUPO_MAX_CARRO = "El cupo maximo para Carros es de " + CUPO_CARROS + " puestos";
	public static final String ERROR_DIA_HABIL = "No puede ingresar porque no esta en un dia habil";
	public static final int DIA_NO_HABIL_1 = Calendar.SUNDAY;
	public static final int DIA_NO_HABIL_2 = Calendar.MONDAY;
	public static int cupoUsoCarros = 1;
	public static int cupoUsoMotos = 1;
	
	private MyValues() {
	    // No requiere parametros de entrada
	}
	
	public static int getCupoUsoCarros() {
		return cupoUsoCarros;
	}
	public static void setCupoUsoCarros(int cupoUsCarros) {
		cupoUsoCarros = cupoUsCarros;
	}
	public static int getCupoUsoMotos() {
		return cupoUsoMotos;
	}
	public static void setCupoUsoMotos(int cupoUsMotos) {
		cupoUsoMotos = cupoUsMotos;
	}	
}
