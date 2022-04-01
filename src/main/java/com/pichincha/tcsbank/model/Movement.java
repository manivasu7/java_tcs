package com.pichincha.tcsbank.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String type;
    private double amount;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Movement(String date, String type, double amount, Account account) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movement movement = (Movement) o;

        return id != null ? id.equals(movement.id) : movement.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
