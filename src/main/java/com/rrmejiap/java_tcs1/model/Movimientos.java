package com.rrmejiap.java_tcs1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoMovimiento;
	private String descripcionMovimiento;
	private String montoMovimiento;
	private String numeroMovimiento;
	private String fechaMovimiento;
	private String usuarioMovimiento;
	
	@ManyToOne
	private Cuentas cuantas;

}
