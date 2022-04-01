package com.ejercicio.contabilidad.model;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.dto.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tran;
    private String description;
    private float amount_tran;
    private String credit_debit;



    @ManyToOne
    private Accounts account;

    public TransactionDto ToDto() {
        return new TransactionDto(id_tran,description,amount_tran,credit_debit,account);
    }



}
