package com.ejercicio.contabilidad.dto;

import com.ejercicio.contabilidad.model.Accounts;
import com.ejercicio.contabilidad.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDto {
    private Integer id_tran;
    private String description;
    private float amount_tran;
    private String credit_debit;

    private Accounts account;

    public Transaction toEntity() {
        return new Transaction(id_tran,description,amount_tran,credit_debit, account);
    }

}
