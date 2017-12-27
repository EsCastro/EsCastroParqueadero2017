package com.ceiba.parqueadero.parqueadero.dto.integral;

import java.nio.charset.Charset;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.parqueadero.parqueadero.ParqueaderoApplication;
import com.ceiba.parqueadero.parqueadero.service.VehiculoService;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ParqueaderoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VigilanteControllerTest {
	@Autowired
	private VehiculoService vehiculoService;
	
	 private ResponseEntity<HashMap> response;
	 
	    /*@Test
	    public void iCallGetOn(String url) {
	    	ResponseEntity<Response> response = this.vehiculoService.getVehiculoByPlaca("/", Response.class, new HashMap<>());
	        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	        response.getBody().getMessage().equals("Hello World!");
	    }*/
	
	
	
}
