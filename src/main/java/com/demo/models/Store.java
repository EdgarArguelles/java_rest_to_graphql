package com.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString(of = {"id", "name"})
@Entity
@Table(name = "store")
public class Store {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private Double sellsPerMonth;

    @Getter
    @Setter
    private String whereMoneyIsSaved;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Game> games;

    public Store(Long id) {
        this.id = id;
    }

    public Store(String name, String address, String phone, Double sellsPerMonth, String whereMoneyIsSaved, Set<Game> games) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.sellsPerMonth = sellsPerMonth;
        this.whereMoneyIsSaved = whereMoneyIsSaved;
        this.games = games;
    }
}
