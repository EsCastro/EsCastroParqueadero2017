package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.util.Calendar;

public class Parqueadero {
	private int cupoMotos;
	private int cupoCarros;
	
	public Parqueadero() {
		super();
	}
	
	/**
	 * Funcio que me valida si hay cupo disponible para carros y motos
	 * @param tipoVehiculo, si es carro o moto
	 * @return true si hay cupo, false si no hay cupo
	 */
	public boolean cupoDisponible(int tipoVehiculo){
		boolean ban = false;
		if((tipoVehiculo == TIPO_CARRO) && (cupoUsoCarros <= CUPO_CARROS)){
			ban = true;
		}else if((tipoVehiculo == TIPO_MOTO) && (cupoUsoMotos <= CUPO_MOTOS)){
			ban = true;
		}		
		return ban;
	}
	
	
	/**
	 * Metodo que me indica si la placa esta autorizada para ingresar
	 * @param placa, placa del vehiculo
	 * @return true si esta autorizada, false si no esta autorizada
	 */
	public boolean placaAutorizada(String placa){
		boolean ban = true;
		Calendar diaHoy = Calendar.getInstance();
		if((INICIAL_PLACA_AUTORIZADA.equals(placa.substring(0, 1).toUpperCase())) && ((diaHoy.get(Calendar.DAY_OF_WEEK) != DIA_NO_HABIL_1)
															       || (diaHoy.get(Calendar.DAY_OF_WEEK) != DIA_NO_HABIL_2))){
			ban = false;
		}
		return ban;
	}
	
	/**
	 * Calcula el valor total a pagar
	 * @param vehiculo
	 * @return
	 * @throws ParseException 
	 */
	public Vehiculo totalPagar(Vehiculo vehiculo) throws ParseException{
		Vehiculo vehiculoRes = vehiculo;
		if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			vehiculoRes = valorPagarCarro(vehiculo);
		}else if (vehiculo.getTipoVehiculo() == TIPO_MOTO){
			vehiculoRes = valorPagarMoto(vehiculo);
		}
		return vehiculoRes;
	}
	
	public void liberarCupo(Vehiculo vehiculo){		
		if(vehiculo.getTipoVehiculo() == TIPO_CARRO){
			int cupoCarro = getCupoUsoCarros();
			setCupoUsoCarros(cupoCarro - 1);
		}else{
			int cupoMoto = getCupoUsoMotos();
			setCupoUsoMotos(cupoMoto - 1);
		}
	}
	
	/**
	 * Cobrar Carro
	 * @return
	 * @throws ParseException 
	 */
	public Vehiculo valorPagarCarro(Vehiculo vehiculo) throws ParseException{
		int dias=0;
        int horas=0;
        int minutos=0;
        int diferencia=0;
        double valorPagar=0.0;
		diferencia = (int)((vehiculo.getFechaSalida().getTime() - vehiculo.getFechaIngreso().getTime()) / 1000);
		
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
            if(minutos > 0)
            	horas++;
        }
        
        if(dias > 0 && horas <= LIMITE_VALOR_DIA){
        	valorPagar = ((dias * VALOR_DIA_CARRO) + (horas * VALOR_HORA_CARRO));
        }else if(dias > 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_CARRO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA){
        	valorPagar = (horas * VALOR_HORA_CARRO);
        }else if(dias == 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_CARRO);
        }
        vehiculo.setValorPagar(valorPagar);
        return vehiculo;		
	}
	
	/**
	 * Cobrar Carro
	 * @return
	 * @throws ParseException 
	 */
	public Vehiculo valorPagarMoto(Vehiculo vehiculo) throws ParseException{
		int dias=0;
        int horas=0;
        int minutos=0;
        int diferencia=0;
        double valorPagar=0.0;
		diferencia = (int)((vehiculo.getFechaSalida().getTime() - vehiculo.getFechaIngreso().getTime()) / 1000);
		
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
            if(minutos > 0)
            	horas++;
        }
        
    	if(dias > 0 && horas <= LIMITE_VALOR_DIA){
        	valorPagar = ((dias * VALOR_DIA_MOTO) + (horas * VALOR_HORA_MOTO));
        }else if(dias > 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_MOTO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA){
        	valorPagar = (horas * VALOR_HORA_MOTO);
        }else if(dias == 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_MOTO);
        }
        if(vehiculo.getCilindraje() >= ALTO_CILINDRAJE){
        	valorPagar = valorPagar + VALOR_ADICIONAL_CILINDRAJE;
        }        
        vehiculo.setValorPagar(valorPagar);
        return vehiculo;		
	}
}
