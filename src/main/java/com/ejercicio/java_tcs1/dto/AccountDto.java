package com.ejercicio.java_tcs1.dto;

import com.ejercicio.java_tcs1.model.Account;
import com.ejercicio.java_tcs1.model.Movement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;

    private String name;
    private String lastName;
    private Long numAccount;
    private String typeAccount;
    private Double amount;


    @JsonIgnore
    public Account getAsEntity(){
        return new Account(this.id, this.name, this.lastName,this.numAccount, this.typeAccount,this.amount);
    }
}
