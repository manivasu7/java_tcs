package com.ejercicio.java_tcs1.model;

import com.ejercicio.java_tcs1.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private Long numAccount;
    private String typeAccount;
    private Double amount;


    public AccountDto getAsDto(){
        return new AccountDto(this.id, this.name, this.lastName,this.numAccount, this.typeAccount,this.amount);
    }
}
