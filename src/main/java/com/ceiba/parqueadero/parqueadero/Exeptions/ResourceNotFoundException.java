package com.ceiba.parqueadero.parqueadero.Exeptions;

public class ResourceNotFoundException extends RuntimeException {
	 
    private Integer resourceId;
 
    public ResourceNotFoundException(Integer resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
