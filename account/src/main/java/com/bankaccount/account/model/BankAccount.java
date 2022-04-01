package com.bankaccount.account.model;

import com.bankaccount.account.dto.BankAccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private Date openingDate;

    private Double countableBalance;

    private String status;

    private String owner;

    private String accountType;

    public BankAccountDto getAsDto() {
        return new BankAccountDto(this.id, this.accountNumber, this.openingDate, this.countableBalance, this.status, this.owner, this.accountType);
    }
}