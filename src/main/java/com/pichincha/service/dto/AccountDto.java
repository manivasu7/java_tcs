package com.pichincha.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.service.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
public class AccountDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String type;
    private String name;
    private String lastName;
    private Double amount;

    @JsonIgnore
    public Account getAsEntity(){
        return new Account(this.id, this.number, this.type, this.name, this.lastName, this.amount);
    }

}
