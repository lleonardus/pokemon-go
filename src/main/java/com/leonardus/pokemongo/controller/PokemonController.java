package com.leonardus.pokemongo.controller;

import com.leonardus.pokemongo.controller.filter.PokemonParams;
import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@Tag(name = "Pokémon")
@ResponseStatus(HttpStatus.OK)
public class PokemonController {
    @Autowired
    PokemonService service;

    @GetMapping
    @Operation(summary = "List all pokémons based on passed parameters",
            parameters = {
                    @Parameter(name = "page", description = "Zero-based page index (0..N)"),
                    @Parameter(name = "size", description = "The size of the page to be returned"),
    })
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
    @Operation(summary = "List pokémons sorted by attack",
            parameters = {
                    @Parameter(name = "page", description = "Zero-based page index (0..N)"),
                    @Parameter(name = "size", description = "The size of the page to be returned"),
            })
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
    @Operation(summary = "List pokémons sorted by defense",
            parameters = {
                    @Parameter(name = "page", description = "Zero-based page index (0..N)"),
                    @Parameter(name = "size", description = "The size of the page to be returned"),
            })
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
    @Operation(summary = "List pokémons sorted by stat total (def + atk + sta)",
            parameters = {
                    @Parameter(name = "page", description = "Zero-based page index (0..N)"),
                    @Parameter(name = "size", description = "The size of the page to be returned"),
            })
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
    @Operation(summary = "List pokémons sorted by CP",
            parameters = {
                    @Parameter(name = "page", description = "Zero-based page index (0..N)"),
                    @Parameter(name = "size", description = "The size of the page to be returned"),
            })
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
