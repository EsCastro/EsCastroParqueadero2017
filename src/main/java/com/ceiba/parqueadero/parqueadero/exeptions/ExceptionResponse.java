package com.ceiba.parqueadero.parqueadero.exeptions;

public class ExceptionResponse {

    private String errorCode;
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