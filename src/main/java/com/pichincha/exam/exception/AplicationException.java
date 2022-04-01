package com.pichincha.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AplicationException(String nombreDelRecurso, Throwable e) {
		super(String.format("Error: %s ", nombreDelRecurso), e);
	}

}
