package com.bankaccount.account.model;

import com.bankaccount.account.dto.BankAccountDto;
import com.bankaccount.account.dto.BankAccountMovementsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountMovements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;

    private Long transactionNumber;

    private String description;

    private String accountInputOutput;

    private Double amount;

    private Date date;

    @JoinColumn(name = "bankAccount_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private BankAccount bankAccount;

    public BankAccountMovementsDto getAsDto() {
        return new BankAccountMovementsDto(this.id, this.transactionType, this.transactionNumber, this.description, this.accountInputOutput, this.amount, this.date);
    }
}