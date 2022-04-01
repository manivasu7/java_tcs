package com.ejercicio.java_tcs1.dto;

import com.ejercicio.java_tcs1.model.Account;
import com.ejercicio.java_tcs1.model.Movement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovementDto {
    private Long id;

    private Date name;
    private String description;
    private Double value;
    private String type;


    @JsonIgnore
    public Movement getAsEntity() {
        return new Movement(this.id, this.name, this.description, this.value, this.type);
    }
}
