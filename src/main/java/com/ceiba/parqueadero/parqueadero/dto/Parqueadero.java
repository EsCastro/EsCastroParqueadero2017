package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Parqueadero {
	private int cupoMotos;
	private int cupoCarros;
	private double vlrHoraMoto;
	private double vlrHoraCarro;
	private double vlrDiaMoto;
	private double vlrDiaCarro;
	private double vlrAdicionalCc;
	
	public Parqueadero() {
		super();
	}
	
	/**
	 * Funcio que me valida si hay cupo disponible para carros y motos
	 * @param tipoVehiculo, si es carro o moto
	 * @return true si hay cupo, false si no hay cupo
	 */
	public boolean cupoDisponible(int tipoVehiculo){
		boolean ban = false;
		
		if((tipoVehiculo == TIPO_CARRO) && (cupoUsoCarros <= CUPO_CARROS)){
			ban = true;
		}else if((tipoVehiculo == TIPO_MOTO) && (cupoUsoMotos <= CUPO_MOTOS)){
			ban = true;
		}		
		return ban;
	}
	
	
	/**
	 * Metodo que me indica si la placa esta autorizada para ingresar
	 * @param placa, placa del vehiculo
	 * @return true si esta autorizada, false si no esta autorizada
	 */
	public boolean placaAutorizada(String placa){
		boolean ban = true;
		Calendar diaHoy = Calendar.getInstance();
		
		if((INICIAL_PLACA_AUTORIZADA.equals(placa.substring(0, 1))) && ((diaHoy.get(Calendar.DAY_OF_WEEK) == DIA_NO_HABIL_1)
															       || (diaHoy.get(Calendar.DAY_OF_WEEK) == DIA_NO_HABIL_2))){
			ban = false;
		}
		return ban;
	}
	
	/**
	 * Devuelve el valor a pagar
	 * @param vechiculo
	 * @return
	 * @throws ParseException 
	 */
	public Vehiculo totalPagar(Vehiculo vehiculo) throws ParseException{		
		double valorPagar = 0.0;
		
		if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			valorPagar = vehiculo.valorPagarCarro();
		}else if (vehiculo.getTipoVehiculo() == TIPO_MOTO){
			valorPagar = vehiculo.valorPagarMoto();
		}
		
		vehiculo.setValorPagar(valorPagar);
		return vehiculo;
	}
	
	public int getCupoMotos() {
		return cupoMotos;
	}
	public void setCupoMotos(int cupoMotos) {
		this.cupoMotos = cupoMotos;
	}
	public int getCupoCarros() {
		return cupoCarros;
	}
	public void setCupoCarros(int cupoCarros) {
		this.cupoCarros = cupoCarros;
	}
	public double getVlrHoraMoto() {
		return vlrHoraMoto;
	}
	public void setVlrHoraMoto(double vlrHoraMoto) {
		this.vlrHoraMoto = vlrHoraMoto;
	}
	public double getVlrHoraCarro() {
		return vlrHoraCarro;
	}
	public void setVlrHoraCarro(double vlrHoraCarro) {
		this.vlrHoraCarro = vlrHoraCarro;
	}
	public double getVlrDiaMoto() {
		return vlrDiaMoto;
	}
	public void setVlrDiaMoto(double vlrDiaMoto) {
		this.vlrDiaMoto = vlrDiaMoto;
	}
	public double getVlrDiaCarro() {
		return vlrDiaCarro;
	}
	public void setVlrDiaCarro(double vlrDiaCarro) {
		this.vlrDiaCarro = vlrDiaCarro;
	}
	public double getVlrAdicionalCc() {
		return vlrAdicionalCc;
	}
	public void setVlrAdicionalCc(double vlrAdicionalCc) {
		this.vlrAdicionalCc = vlrAdicionalCc;
	}		
}
