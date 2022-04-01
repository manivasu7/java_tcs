package com.pichincha.cuenta.java_tcs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer movementId;
    private Double initialBalance;
    private Double finalBalance;

    @JoinColumn(name = "accountId")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    private Account account;

}
