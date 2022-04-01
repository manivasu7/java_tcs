package com.pichincha.tcsbank.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private double balance;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Movement> movements = new ArrayList<>();

    public Account(String owner, double balance, List<Movement> movements) {
        this.owner = owner;
        this.balance = balance;
        this.movements = movements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return id != null ? id.equals(account.id) : account.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}