package com.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString(of = {"id", "name"})
@Entity
@Table(name = "category")
@GraphQLType(description = "Category which a game can belong to")
public class Category {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private String description;

    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "smallint")
    private Integer minAge;

    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "smallint")
    private Integer status;

    @Getter
    @Setter
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore // avoid infinite Category-Game loop
    private List<Game> games;

    public Category(Long id) {
        this.id = id;
    }

    public Category(String name, String description, Integer minAge, Integer status) {
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.status = status;
    }
}
