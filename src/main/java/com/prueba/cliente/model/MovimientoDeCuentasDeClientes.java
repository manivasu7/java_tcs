package com.prueba.cliente.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovimientoDeCuentasDeClientes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idMovimiento;
	
	@Temporal(TemporalType.DATE)
	private Date fechaTransaccion;
    
    public String tipo;
    public double monto;
    
    @ManyToOne
    @JoinColumn(name = "idCuenta")
    private CuentasDeClientes cuenta;
    
}
