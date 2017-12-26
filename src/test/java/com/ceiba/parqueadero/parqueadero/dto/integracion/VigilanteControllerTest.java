package com.ceiba.parqueadero.parqueadero.dto.integracion;

import java.text.ParseException;

import org.junit.Before;
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

import com.ceiba.parqueadero.parqueadero.builder.VehiculoBuilder;
import com.ceiba.parqueadero.parqueadero.controller.VigilanteController;
import com.ceiba.parqueadero.parqueadero.dto.Vehiculo;
import com.ceiba.parqueadero.parqueadero.entities.VehiculoEntity;
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
	String exampleCourseJson = "{\"tipoVehiculo\":2,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1514238486491,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
	
	@Test
	public void salidaVehiculoTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		
		//Act
		Mockito.when(
				vehiculoService.getVehiculoByPlaca(Mockito.anyString())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/salidaVehiculo/"+ PLACA +"").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"tipoVehiculo\":1,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":8000.0}";
		System.out.println("Lo esperado es: "+expected);
		
		System.out.println("El resultado es: "+result.getResponse().getContentAsString());
		
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void ingresarVehiculoTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.conFechaIngreso("2017-12-20 8:00:00").conFechaSalida("2017-12-21 8:00:00").build();
		
		//Act
		Mockito.when(
				vehiculoService.saveVehiculo(Mockito.anyObject())).thenReturn(vehiculo);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/ingresarVehiculo")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"tipoVehiculo\":1,\"placa\":\"PPA25D\",\"cilindraje\":200,\"fechaIngreso\":1513774800000,\"fechaSalida\":1513861200000,\"valorPagar\":0.0}";
	
		//Assert
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);		
	}

}
