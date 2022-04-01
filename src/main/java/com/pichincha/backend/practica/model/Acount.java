package com.pichincha.backend.practica.model;

import com.pichincha.backend.practica.dto.AcountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private String lastnameClient;
    private String number;
    private String type;
    private Double monto;

    public AcountDto ToDto() {
        return new AcountDto(this.id,this.nameClient,this.lastnameClient,this.number,this.type,this.monto);
    }
}
