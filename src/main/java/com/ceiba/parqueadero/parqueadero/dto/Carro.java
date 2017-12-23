package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.LIMITE_VALOR_DIA;
import static com.ceiba.parqueadero.parqueadero.util.MyValues.TIPO_CARRO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Carro extends Vehiculo{	
	public Carro(int tipoVehiculo, String placa, int cilindraje, java.util.Date fechaIngreso,
			java.util.Date fechaSalida) {
		super(tipoVehiculo, placa, cilindraje, fechaIngreso, fechaSalida);
	}
	
	/*public double valorPagar(){
		int dias=0;
        int horas=0;
        int minutos=0;
        int diferencia=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date fechaInicial=dateFormat.parse("2017-12-20 8:00:00");
        Date fechaFinal=dateFormat.parse("2016-02-15 11:10:10");
        
		System.out.println("Fecha Entrada " + fechaInicial.getTime());
		System.out.println("Fecha Salida " + vehiculo.getFechaSalida().getTime());
		diferencia = (int)((vehiculo.getFechaSalida().getTime() - fechaInicial.getTime()) / 1000);
		
		/////////////////////////////////////
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }
        
        if((vehiculo.getTipoVehiculo() == TIPO_CARRO) && 
           (dias > 0 && horas < LIMITE_VALOR_DIA)){
        	valorPagar = (dias * )
        
        System.out.println("Hay "+dias+" dias, "+horas+" horas, "+minutos+" minutos y "+diferencia+" segundos de diferencia");
        
		return 0.0;
	}*/
	
}
