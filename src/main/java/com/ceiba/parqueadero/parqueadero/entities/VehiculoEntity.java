package com.ceiba.parqueadero.parqueadero.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class VehiculoEntity {
	
	@Id
	@NotNull
	private String placa;
	
	@NotNull
	private Integer cilindraje;
	
	@NotNull
	private Integer tipoVehiculo;
	
	private Date fechaIngreso;
	
	private Date fechaSalida;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "VehiculoEntity [placa=" + placa + ", cilindraje=" + cilindraje + ", tipoVehiculo="
				+ tipoVehiculo + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + "]";
	}
	
	
}
