package com.ceiba.parqueadero.parqueadero.dto;

import java.util.Date;

public class Vehiculo {
	private int tipoVehiculo;
	private String placa;	
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valorPagar;
	
	public Vehiculo(int tipoVehiculo, String placa, int cilindraje, Date fechaIngreso, Date fechaSalida) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
}
