package com.ceiba.parqueadero.parqueadero.exeptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {
	
	@JsonProperty("errorCode")
    private String errorCode;
	@JsonProperty("errorMessage")
    private String errorMessage;

    public ExceptionResponse() {
    	//No se requiere incluir parametros al metodo
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}