package com.leonardus.pokemongo.controller;

import com.leonardus.pokemongo.controller.filter.PokemonParams;
import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@ResponseStatus(HttpStatus.OK)
public class PokemonController {
    @Autowired
    PokemonService service;

    @GetMapping
    public List<Pokemon> findByParams(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String type,
                                      @RequestParam(required = false) Integer generation,
                                      @RequestParam(required = false) Boolean notGettable,
                                      @RequestParam(required = false) Integer familyId,
                                      @RequestParam(required = false) Boolean legendary,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "20") int size){

        PokemonParams pokemonParams = new PokemonParams(name, type, generation, notGettable, familyId, legendary);

        return service.findByParams(pokemonParams.toSpec(), page, size);
    }

    @GetMapping("/top-attackers")
    public List<Pokemon> topAttackers(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) Integer generation,
                                      @RequestParam(required = false) Boolean notGettable,
                                      @RequestParam(required = false) Boolean legendary,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "20") int size){
        PokemonParams pokemonParams = PokemonParams.builder()
                .type(type).generation(generation).notGettable(notGettable).legendary(legendary).build();

        return service.topAttackers(pokemonParams.toSpec(), page, size);
    }

    @GetMapping("/top-defenders")
    public List<Pokemon> topDefenders(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) Integer generation,
                                      @RequestParam(required = false) Boolean notGettable,
                                      @RequestParam(required = false) Boolean legendary,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "20") int size){
        PokemonParams pokemonParams = PokemonParams.builder()
                .type(type).generation(generation).notGettable(notGettable).legendary(legendary).build();

        return service.topDefenders(pokemonParams.toSpec(), page, size);
    }

    @GetMapping("/best-pokemon-by-stat-total")
    public List<Pokemon> bestPokemonByStatTotal(@RequestParam(required = false) String type,
                                                @RequestParam(required = false) Integer generation,
                                                @RequestParam(required = false) Boolean notGettable,
                                                @RequestParam(required = false) Boolean legendary,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "20") int size){
        PokemonParams pokemonParams = PokemonParams.builder()
                .type(type).generation(generation).notGettable(notGettable).legendary(legendary).build();

        return service.bestPokemonByStatTotal(pokemonParams.toSpec(), page, size);
    }

    @GetMapping("/best-pokemon-by-cp")
    public List<Pokemon> bestPokemonByCp(@RequestParam(required = false) String type,
                                         @RequestParam(required = false) Integer generation,
                                         @RequestParam(required = false) Boolean notGettable,
                                         @RequestParam(required = false) Boolean legendary,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size){
        PokemonParams pokemonParams = PokemonParams.builder()
                .type(type).generation(generation).notGettable(notGettable).legendary(legendary).build();

        return service.bestPokemonByCp(pokemonParams.toSpec(), page, size);
    }
}
