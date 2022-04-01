package com.rrmejiap.java_tcs1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
@Entity
public class Cuentas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoCuenta;
	private String numeroCuenta;
	private String nombreCuenta;
	private String montoCuenta;
	private String fechaCuenta;
	private String usuarioCuenta;
}
