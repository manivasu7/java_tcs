package com.chapterbackendbp.movimientos.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "chapbp_movimientos")
public class Movimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long _id;

    @Column
    private long desdecuenta;

    @Column
    private long hastacuenta;

    @Column
    private float valor;

    @Column
    private Date fecha;
    
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cuenta cuentaCliente;



    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getDesdecuenta() {
        return this.desdecuenta;
    }

    public void setDesdecuenta(long desdecuenta) {
        this.desdecuenta = desdecuenta;
    }

    public long getHastacuenta() {
        return this.hastacuenta;
    }

    public void setHastacuenta(long hastacuenta) {
        this.hastacuenta = hastacuenta;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuentaCliente() {
        return this.cuentaCliente;
    }

    public void setCuentaCliente(Cuenta cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }
    

}
