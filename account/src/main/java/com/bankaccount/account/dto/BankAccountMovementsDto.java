package com.bankaccount.account.dto;

import com.bankaccount.account.model.BankAccount;
import com.bankaccount.account.model.BankAccountMovements;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountMovementsDto {
    private Long id;

    private String tipoTransaccion;

    private Long numeroTransaccion;

    private String descripcion;

    private String beneficiarioOrdenante;

    private Double monto;

    private Date fecha;

    @JsonIgnore
    public BankAccountMovements getAsEntity() {
        return new BankAccountMovements(this.id, this.tipoTransaccion, this.numeroTransaccion, this.descripcion, this.beneficiarioOrdenante, this.monto, this.fecha, new BankAccount());
    }
}