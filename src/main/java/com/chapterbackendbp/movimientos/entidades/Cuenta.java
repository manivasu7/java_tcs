package com.chapterbackendbp.movimientos.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "chapbp_cuentas")
public class Cuenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private long _id;

    @Column
    private String nombrededliente;

    @Column
    private long numerodecuenta;

    @Column
    private Date fechaunirse;

    @OneToMany(mappedBy = "cuentaCliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Movimiento> movimientos;

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }


    public String getNombrededliente() {
        return this.nombrededliente;
    }

    public void setNombrededliente(String nombrededliente) {
        this.nombrededliente = nombrededliente;
    }

    public long getNumerodecuenta() {
        return this.numerodecuenta;
    }

    public void setNumerodecuenta(long numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public Date getFechaunirse() {
        return this.fechaunirse;
    }

    public void setFechaunirse(Date fechaunirse) {
        this.fechaunirse = fechaunirse;
    }
   

    public List<Movimiento> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    
}
