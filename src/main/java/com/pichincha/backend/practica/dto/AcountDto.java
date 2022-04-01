package com.pichincha.backend.practica.dto;

import com.pichincha.backend.practica.model.Acount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcountDto {
    private Long id;
    private String nameClient;
    private String lastnameClient;
    private String number;
    private String type;
    private Double monto;

    public Acount toEntity() {
        return new Acount(this.id,this.nameClient,this.lastnameClient,this.number,this.type,this.monto);
    }
}

