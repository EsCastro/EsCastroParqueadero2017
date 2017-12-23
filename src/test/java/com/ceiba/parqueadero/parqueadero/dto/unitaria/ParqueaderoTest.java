package com.ceiba.parqueadero.parqueadero.dto.unitaria;

import com.ceiba.parqueadero.parqueadero.dto.Parqueadero;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import org.junit.Assert;
import org.junit.Test;

import testdatabuilder.VehiculoTestDataBuilder;

public class ParqueaderoTest {
	
	@Test
	public void cupoDisponibleNegativo(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		boolean resultado = parqueadero.cupoDisponible(vehiculo.getTipoVehiculo());
		
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void cupoDisponiblePositivo(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		boolean resultado = parqueadero.cupoDisponible(vehiculo.getTipoVehiculo());
		
		//Assert
		Assert.assertTrue(resultado);
	}
}
