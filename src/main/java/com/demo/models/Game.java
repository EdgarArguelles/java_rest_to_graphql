package com.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString(of = {"id", "name"})
@Entity
@Table(name = "game")
public class Game {

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
    @Column(nullable = false)
    private Double price;

    @Getter
    @Setter
    private String note;

    @Getter
    @Setter
    private Integer bugsFound;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "games", fetch = FetchType.LAZY)
    @JsonIgnore // avoid infinite Game-Store loop
    private List<Store> stores;

    public Game(Long id) {
        this.id = id;
    }

    public Game(String name, Double price, String note, Integer bugsFound, Category category) {
        this.name = name;
        this.price = price;
        this.note = note;
        this.bugsFound = bugsFound;
        this.category = category;
    }
}
