package com.pichincha.backend.practica.model;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.dto.MovementDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Double value;
    private String description;

    @ManyToOne
    private Acount acount;

    public MovementDto ToDto() {
        AcountDto obj = null;
        if(acount != null)
        {
            obj=acount.ToDto();
        }
        return new MovementDto(this.id, this.date, this.value, this.description);
    }
}
