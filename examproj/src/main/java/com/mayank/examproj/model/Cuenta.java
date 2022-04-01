package com.mayank.examproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mayank.examproj.dto.CuentaDto;

@Entity

public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public long numeroCuenta;
	public String nombre;

	public String apellido;

	public String tipoCuenta;

	public Cuenta() {
	}

	public CuentaDto getAsTo() {
		return new CuentaDto(this.id, this.numeroCuenta, this.nombre, this.apellido, this.tipoCuenta);
	}

	public Cuenta(long id, long numeroCuenta, String nombre, String apellido, String tipoCliente) {
		super();
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoCuenta = tipoCliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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

}
