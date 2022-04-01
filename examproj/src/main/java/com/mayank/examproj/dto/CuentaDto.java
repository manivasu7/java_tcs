package com.mayank.examproj.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mayank.examproj.model.Cuenta;

public class CuentaDto {
	public long id;
	public long numeroCuenta;
	public String nombre;
	public String apellido;
	public String tipoCuenta;

	@JsonIgnore
	public Cuenta getAsEntity() {
		return new Cuenta(this.id, this.numeroCuenta, this.nombre, this.apellido, this.tipoCuenta);
	}

	public CuentaDto() {
	}

	public CuentaDto(long id, long numeroCuenta, String nombre, String apellido, String tipoCuenta) {
		super();
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoCuenta = tipoCuenta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
