package com.leonardus.pokemongo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokemons")
public class Pokemon{
    @Column(name = "row_number")
    private Integer rowNumber;
    @Id
    private String name;
    @Column(name = "pokedex_number")
    private Integer pokedexNumber;
    @Column(name = "img_name")
    private String imgName;
    private Integer generation;
    @Column(name = "evolution_stage")
    private String evolutionStage;
    private Boolean evolved;
    @Column(name = "family_id")
    private Integer familyId;
    @Column(name = "cross_gen")
    private Boolean crossGen;
    @Column(name = "type_1")
    private String type1;
    @Column(name = "type_2")
    private String type2;
    @Column(name = "weather_1")
    private String weather1;
    @Column(name = "weather_2")
    private String weather2;
    @Column(name = "stat_total")
    private Integer statTotal;
    private Integer atk;
    private Integer def;
    private Integer sta;
    private Boolean legendary;
    private Integer aquireable;
    private Boolean spawns;
    private Boolean regional;
    private Integer raidable;
    private Integer hatchable;
    private Boolean shiny;
    private Boolean nest;
    @Column(name = "new")
    private Boolean newPokemon;
    @Column(name = "not_gettable")
    private Boolean notGettable;
    @Column(name = "future_evolve")
    private Boolean futureEvolve;
    @Column(name = "full_CP_40")
    private Integer cp40;
    @Column(name = "full_CP_39")
    private Integer cp39;
}
