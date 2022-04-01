package com.ejercicio.contabilidad.dto;

import com.ejercicio.contabilidad.model.Accounts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {
    private Integer id_account;
    private String name_account;
    private String code_account;

    public Accounts toEntity() {
        return new Accounts(id_account,name_account,code_account);
    }


}
