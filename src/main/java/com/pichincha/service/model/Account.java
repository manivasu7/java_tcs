package com.pichincha.service.model;

import com.pichincha.service.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String type;
    private String name;
    private String lastName;
    private Double amount;

    public AccountDto getAsDto(){
        return new AccountDto(this.id, this.number, this.type, this.name, this.lastName, this.amount);
    }

}
