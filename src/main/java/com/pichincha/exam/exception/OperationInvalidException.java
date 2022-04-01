package com.pichincha.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OperationInvalidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OperationInvalidException(String mensaje, String nombreDelCampo, String valorDelCampo) {
		super(String.format("%s La operacion no se puede realizar: %s : %s", mensaje,nombreDelCampo,valorDelCampo));
	}
	
	

}
