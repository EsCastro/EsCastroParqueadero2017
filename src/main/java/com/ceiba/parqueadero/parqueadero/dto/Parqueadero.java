package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parqueadero {
	private int cupoMotos, cupoCarros;
	private double vlr_hora_moto,vlr_hora_carro,vlr_dia_moto,vlr_dia_carro,vlr_adicional_cc;
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
		
		if((tipoVehiculo == TIPO_CARRO) && (CUPO_USO_CARROS <= CUPO_CARROS)){
			ban = true;
		}else if((tipoVehiculo == TIPO_MOTO) && (CUPO_USO_MOTOS <= CUPO_MOTOS)){
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
		vehiculo.setFechaSalida(new Date());
		double valorPagar = 0.0;;
		
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
	public double getVlr_hora_moto() {
		return vlr_hora_moto;
	}
	public void setVlr_hora_moto(double vlr_hora_moto) {
		this.vlr_hora_moto = vlr_hora_moto;
	}
	public double getVlr_hora_carro() {
		return vlr_hora_carro;
	}
	public void setVlr_hora_carro(double vlr_hora_carro) {
		this.vlr_hora_carro = vlr_hora_carro;
	}
	public double getVlr_dia_moto() {
		return vlr_dia_moto;
	}
	public void setVlr_dia_moto(double vlr_dia_moto) {
		this.vlr_dia_moto = vlr_dia_moto;
	}
	public double getVlr_dia_carro() {
		return vlr_dia_carro;
	}
	public void setVlr_dia_carro(double vlr_dia_carro) {
		this.vlr_dia_carro = vlr_dia_carro;
	}
	public double getVlr_adicional_cc() {
		return vlr_adicional_cc;
	}
	public void setVlr_adicional_cc(double vlr_adicional_cc) {
		this.vlr_adicional_cc = vlr_adicional_cc;
	}		
}
