package com.ceiba.parqueadero.parqueadero.dto.integracion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;

import testdatabuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VigilanteController.class, secure = false)
public class VigilanteControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VehiculoService vehiculoService;
	
	private static final String PLACA_CARRO = "XWK96C";
	
	@Test
	public void ingresarVehiculoTest() throws Exception{
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculoEnvio = vehiculoTestDataBuilder.conTipoVehiculo(1).conPlaca(PLACA_CARRO).build();
		String exampleCourseJson = "{\"tipoVehiculo\":1,\"placa\":\"XWK96C\",\"cilindraje\":200,\"fechaIngreso\":null,\"fechaSalida\":null,\"valorPagar\":0.0}";
		
		//Act
		Vehiculo vehiculoRespuesta = vehiculoService.saveVehiculo(VehiculoBuilder.convertirAEntity(vehiculoEnvio));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/ingresarVehiculo")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Valor vehiculo respuesta " + result.getResponse().getContentAsString());
		
		//Assert
		Assert.assertEquals(vehiculoEnvio.getPlaca(), vehiculoRespuesta.getPlaca());
	}
}
