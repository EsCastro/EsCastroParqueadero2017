package com.ceiba.parqueadero.parqueadero.dto;

import java.util.Date;

public class Vehiculo {
	private int tipoVehiculo;
	private String placa;	
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valorPagar;
	private int cilindraje;
	
	public Vehiculo(int tipoVehiculo, String placa, Date fechaIngreso, Date fechaSalida, int cilindraje) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cilindraje = cilindraje;
	}
	
	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}	
}
