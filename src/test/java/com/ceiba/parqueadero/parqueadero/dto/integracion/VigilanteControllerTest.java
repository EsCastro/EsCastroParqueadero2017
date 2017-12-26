package com.ceiba.parqueadero.parqueadero.dto.integracion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.parqueadero.parqueadero.controller.VigilanteController;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;

import testdatabuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VigilanteController.class, secure = false)
public class VigilanteControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VehiculoService vehiculoService;
	
	private static final String PLACA = "PPA25D";	
	
	@Test
	public void salidaVehiculoCarroTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(1).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":1,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":8000.0}";
		
		//Act
		Mockito.when(
				vehiculoService.getVehiculoByPlaca(Mockito.anyString())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/salidaVehiculo/"+ PLACA +"").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void salidaVehiculoMotoTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(2).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":4000.0}";
		
		//Act
		Mockito.when(
				vehiculoService.getVehiculoByPlaca(Mockito.anyString())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/salidaVehiculo/"+ PLACA +"").accept(
				MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void salidaVehiculoMotoCCTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(2).conCilindraje(600).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":600,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":6000.0}";
		
		//Act
		Mockito.when(
				vehiculoService.getVehiculoByPlaca(Mockito.anyString())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/salidaVehiculo/"+ PLACA +"").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void ingresarVehiculoCarroTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(1).conCilindraje(1200).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":1,\"placa\":\"PPA25D\",\"cilindraje\":1200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		String exampleCourseJson = "{\"tipoVehiculo\":1,\"placa\":\"PPA25D\",\"cilindraje\":1200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		
		//Act
		Mockito.when(
				vehiculoService.saveVehiculo(Mockito.anyObject())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/ingresarVehiculo")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);		
	}
	
	@Test
	public void ingresarVehiculoMotoTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conFechaIngreso("2017-12-20 8:00:00").conTipoVehiculo(2).conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		String exampleCourseJson = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		
		//Act
		Mockito.when(
				vehiculoService.saveVehiculo(Mockito.anyObject())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/ingresarVehiculo")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
	
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);		
	}
	
	@Test
	public void ingresarVehiculoMotoAltCCTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conTipoVehiculo(2).conCilindraje(600).conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		String expected = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":600,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		String exampleCourseJson = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":600,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
		
		//Act
		Mockito.when(
				vehiculoService.saveVehiculo(Mockito.anyObject())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/ingresarVehiculo")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		

		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);		
	}

}