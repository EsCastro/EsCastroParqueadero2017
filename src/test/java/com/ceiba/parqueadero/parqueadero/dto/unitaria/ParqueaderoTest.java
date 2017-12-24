package com.ceiba.parqueadero.parqueadero.dto.unitaria;
import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;

import com.ceiba.parqueadero.parqueadero.dto.Parqueadero;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import org.junit.Assert;
import org.junit.Test;

import testdatabuilder.VehiculoTestDataBuilder;

public class ParqueaderoTest {
	private static final double VLR_PAGAR_CARRO = 8000.0;
	private static final double VLR_PAGAR_MOTO = 4000.0;
	private static final double VLR_PAGAR_MOTO_ALT_CC = 6000.0;
	private static final int TIPO_VEHICULO_MOTO = 2;
	private static final int CILINDRAJE_ALTO = 600;
	
	@Test
	public void cupoDisponibleNegativo(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		setCupoUsoCarros(getCupoCarros() + 1);
		setCupoUsoMotos(getCupoMotos() + 1);
		
		//Act
		boolean resultado = parqueadero.cupoDisponible(vehiculo.getTipoVehiculo());
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void cupoDisponiblePositivo(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		setCupoUsoCarros(1);
		setCupoUsoMotos(1);
		
		//Act
		boolean resultado = parqueadero.cupoDisponible(vehiculo.getTipoVehiculo());
		
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void totalPagarCarro() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00");
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
				
		//Act
		Vehiculo vehiculoPagar = parqueadero.totalPagar(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", VLR_PAGAR_CARRO -  vehiculoPagar.getValorPagar() == 0);
	}
	
	@Test
	public void totalPagarMoto() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		Vehiculo vehiculoPagar = parqueadero.totalPagar(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", VLR_PAGAR_MOTO -  vehiculoPagar.getValorPagar() == 0);
	}
	
	@Test
	public void totalPagarMotoAltoCC() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE_ALTO).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		Vehiculo vehiculoPagar = parqueadero.totalPagar(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", VLR_PAGAR_MOTO_ALT_CC -  vehiculoPagar.getValorPagar() == 0);
	}	
}
