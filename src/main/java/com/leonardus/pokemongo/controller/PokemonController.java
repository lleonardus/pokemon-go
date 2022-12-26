package com.leonardus.pokemongo.controller;

import com.leonardus.pokemongo.controller.filter.PokemonParams;
import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@ResponseStatus(HttpStatus.OK)
public class PokemonController {
    @Autowired
    PokemonService service;

    @GetMapping
    public List<Pokemon> findByParams(PokemonParams pokemonParams, Pageable pageable){
        return service.findByParams(pokemonParams.toSpec(), pageable);
    }

    @GetMapping("/top-attackers")
    public List<Pokemon> topAttackers(Pageable pageable){
        return service.topAttackers(pageable);
    }

    @GetMapping("/top-defenders")
    public List<Pokemon> topDefenders(Pageable pageable){
        return service.topDefenders(pageable);
    }

    @GetMapping("/best-pokemon-by-stat-total")
    public List<Pokemon> bestPokemonByStatTotal(Pageable pageable){
        return service.bestPokemonByStatTotal(pageable);
    }

    @GetMapping("/best-pokemon-by-cp")
    public List<Pokemon> bestPokemonByCp(Pageable pageable){
        return service.bestPokemonByCp(pageable);
    }
}
