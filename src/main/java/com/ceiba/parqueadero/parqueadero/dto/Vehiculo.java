package com.ceiba.parqueadero.parqueadero.dto;

import static com.ceiba.parqueadero.parqueadero.util.MyValues.*;

import java.text.ParseException;
import java.util.Date;

public class Vehiculo {
	private int tipoVehiculo;
	private String placa;	
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valorPagar;
	
	public Vehiculo(int tipoVehiculo, String placa, int cilindraje, Date fechaIngreso, Date fechaSalida) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	/**
	 * Cobrar Carro
	 * @return
	 * @throws ParseException 
	 */
	public double valorPagarCarro() throws ParseException{
		int dias=0;
        int horas=0;
        int minutos=0;
        int diferencia=0;
		diferencia = (int)((this.fechaSalida.getTime() - this.fechaIngreso.getTime()) / 1000);
		
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
        
        if(dias > 0 && horas <= LIMITE_VALOR_DIA && minutos > 0){
        	valorPagar = ((dias * VALOR_DIA_CARRO) + ((horas + 1) * VALOR_HORA_CARRO));
        }else if(dias > 0 && horas <= LIMITE_VALOR_DIA && minutos == 0){
        	valorPagar = ((dias * VALOR_DIA_CARRO) + (horas * VALOR_HORA_CARRO));
        }else if(dias > 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_CARRO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA && minutos > 0){
        	valorPagar = ((horas + 1) * VALOR_HORA_CARRO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA && minutos == 0){
        	valorPagar = (horas * VALOR_HORA_CARRO);
        }else if(dias == 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_CARRO);
        }
 		return valorPagar;		
	}
	
	/**
	 * Cobrar Carro
	 * @return
	 * @throws ParseException 
	 */
	public double valorPagarMoto() throws ParseException{
		int dias=0;
        int horas=0;
        int minutos=0;
        int diferencia=0;
		diferencia = (int)((this.fechaSalida.getTime() - this.fechaIngreso.getTime()) / 1000);
		
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
        
    	if(dias > 0 && horas <= LIMITE_VALOR_DIA && minutos > 0){
        	valorPagar = ((dias * VALOR_DIA_MOTO) + ((horas + 1) * VALOR_HORA_MOTO));
        }else if(dias > 0 && horas <= LIMITE_VALOR_DIA && minutos == 0){
        	valorPagar = ((dias * VALOR_DIA_MOTO) + (horas * VALOR_HORA_MOTO));
        }else if(dias > 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_MOTO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA && minutos > 0){
        	valorPagar = ((horas + 1) * VALOR_HORA_CARRO);
        }else if(dias == 0 && horas <= LIMITE_VALOR_DIA && minutos == 0){
        	valorPagar = (horas * VALOR_HORA_CARRO);
        }else if(dias == 0 && horas > LIMITE_VALOR_DIA){
        	valorPagar = ((dias + 1) * VALOR_DIA_MOTO);
        }
        if(this.cilindraje >= ALTO_CILINDRAJE){
        	valorPagar = valorPagar + VALOR_ADICIONAL_CILINDRAJE;
        }            
        return valorPagar;		
	}	
	
	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
}
