package com.prueba.cliente.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CuentasDeClientes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idCuenta;
    public String identificacionDelCliente;
    public String nombresDelCliente;
    public String apellidosDelCliente;
    public String tipoDeCliente;
    public String numeroDeCuenta;
    
    @OneToMany(mappedBy = "cuenta")
    private List<MovimientoDeCuentasDeClientes> movimientos;
    
}
