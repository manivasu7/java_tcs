package com.pichincha.backend.practica.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {
    private Long id;
    private String date;
    private Double value;
    private String description;
    private AcountDto acount;

    public MovementDto(Long id, String date, Double value, String description) {
    }
}
