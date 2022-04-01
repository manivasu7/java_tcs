package com.ejercicio.java_tcs1.model;

import com.ejercicio.java_tcs1.dto.MovementDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date name;
    private String description;
    private Double value;
    private String type;




    public MovementDto getAsDto() {
        return new MovementDto(this.id, this.name, this.description, this.value, this.type);
    }
}
