package com.ejercicio.contabilidad.model;

import com.ejercicio.contabilidad.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_account;
    private String name_account;
    private String code_account;

    public AccountDto ToDto() {
        return new AccountDto(id_account,name_account,code_account);
    }
}
