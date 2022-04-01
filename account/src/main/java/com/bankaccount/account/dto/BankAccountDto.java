package com.bankaccount.account.dto;

import com.bankaccount.account.model.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BankAccountDto {
    private long id;

    private String numeroCuenta;

    private Date fechaApertura;

    private Double saldoContable;

    private String estado;

    private String propietario;

    private String tipoCuenta;

    @JsonIgnore
    public BankAccount getAsEntity() {
        return new BankAccount(this.id, this.numeroCuenta, this.fechaApertura, this.saldoContable, this.estado, this.propietario, this.tipoCuenta);
    }
}