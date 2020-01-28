package com.demo.models;

import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.types.GraphQLType;
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
@GraphQLType(description = "Store that sells games")
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

    @Setter
    private Double sellsPerMonth;

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

    @GraphQLIgnore
    public Double getSellsPerMonth() {
        return sellsPerMonth;
    }

    @GraphQLIgnore
    public String getWhereMoneyIsSaved() {
        return whereMoneyIsSaved;
    }
}
