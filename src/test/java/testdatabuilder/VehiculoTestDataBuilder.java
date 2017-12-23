package testdatabuilder;

import java.util.Date;

import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;

public class VehiculoTestDataBuilder {
	private static final int TIPOVEHICULO = 1;
	private static final String PLACA = "PPA25D";
	private static final int CILINDRAJE = 200;
	private static final Date FECHAINGRESO = new Date();
	private static final Date FECHASALIDA = new Date();
	
	private String placa;
	private int tipoVehiculo;
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;

	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.cilindraje = CILINDRAJE;
		this.fechaIngreso = FECHAINGRESO;
		this.fechaSalida = FECHASALIDA;
	}

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestDataBuilder conTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public VehiculoTestDataBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	public Vehiculo build() {
		return new Vehiculo(tipoVehiculo, placa, cilindraje, fechaIngreso, fechaSalida);
	}

}