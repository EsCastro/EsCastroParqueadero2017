package com.ceiba.parqueadero.parqueadero.dto.unitaria;
import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.util.Calendar;

import com.ceiba.parqueadero.parqueadero.dto.Parqueadero;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import org.junit.Assert;
import org.junit.Test;

import testdatabuilder.VehiculoTestDataBuilder;

public class ParqueaderoTest {
	private static final double VLR_PAGAR_CARRO = 24000.0;
	private static final double VLR_PAGAR_MOTO = 16500.0;
	private static final double VLR_PAGAR_MOTO_ALT_CC = 20000.0;
	private static final int TIPO_VEHICULO_MOTO = 2;
	private static final int CILINDRAJE_ALTO = 600;
	private static final String PLACA = "PPA25D";
	private static final String PLACA_NO_AUTORIZADA = "APA25D";
	
	@Test
	public void cupoDisponibleNegativoTest(){
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
	public void cupoDisponiblePositivoTest(){
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
	public void placaAutorizadaTest(){
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		Calendar diaHoy = Calendar.getInstance();
		boolean resultado = false;
		
		//Act
		resultado = parqueadero.placaAutorizada(PLACA);
		
		//Assert
		if((diaHoy.get(Calendar.DAY_OF_WEEK) == DIA_NO_HABIL_1)
			       || (diaHoy.get(Calendar.DAY_OF_WEEK) == DIA_NO_HABIL_2)){
			Assert.assertFalse(resultado);
		}else{
			Assert.assertTrue(resultado);
		}
	}
	
	@Test
	public void placaNoAutorizadaTest(){
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		Calendar diaHoy = Calendar.getInstance();
		boolean resultado = false;
		
		//Act
		resultado = parqueadero.placaAutorizada(PLACA_NO_AUTORIZADA);
				
		//Assert
		if((diaHoy.get(Calendar.DAY_OF_WEEK) != DIA_NO_HABIL_1)
			       || (diaHoy.get(Calendar.DAY_OF_WEEK) != DIA_NO_HABIL_2)){
			Assert.assertFalse(resultado);
		}else{
			Assert.assertTrue(resultado);
		}
	}
	
	@Test
	public void valorPagarCarroTest() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conFechaIngreso("2017-12-19 8:00:00").conFechaSalida("2017-12-21 18:15:05");
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
				
		//Act
		Vehiculo vehiculoPagar = parqueadero.valorPagarCarro(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", VLR_PAGAR_CARRO -  vehiculoPagar.getValorPagar() == 0);
	}
	
	@Test
	public void valorPagarMotoTest() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso("2017-12-17 8:00:00").conFechaSalida("2017-12-21 8:05:00").build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		Vehiculo vehiculoPagar = parqueadero.valorPagarMoto(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", VLR_PAGAR_MOTO -  vehiculoPagar.getValorPagar() == 0);
	}
	
	@Test
	public void valorPagarMotoAltCCTest() throws ParseException{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE_ALTO).conFechaIngreso("2017-12-17 8:00:00").conFechaSalida("2017-12-21 18:00:00").build();
		Parqueadero parqueadero = new Parqueadero();
		
		//Act
		Vehiculo vehiculoPagar = parqueadero.valorPagarMoto(vehiculo);
		
		//Assert
		Assert.assertTrue("Not equals", (VLR_PAGAR_MOTO_ALT_CC + VALOR_ADICIONAL_CILINDRAJE) -  vehiculoPagar.getValorPagar() == 0);
	}

}
