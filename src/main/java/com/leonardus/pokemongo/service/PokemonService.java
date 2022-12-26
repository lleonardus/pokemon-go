package com.leonardus.pokemongo.service;

import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository repository;

    public List<Pokemon> findByParams(Specification<Pokemon> specification, Pageable pageable){
        return repository.findAll(specification, pageable).getContent();
    }

    public List<Pokemon> topAttackers(Pageable pageable){
        return repository.topAttackers(pageable);
    }

    public List<Pokemon> topDefenders(Pageable pageable){
        return repository.topDefenders(pageable);
    }

    public List<Pokemon> bestPokemonByStatTotal(Pageable pageable){
        return repository.bestPokemonByStatTotal(pageable);
    }

    public List<Pokemon> bestPokemonByCp(Pageable pageable){
        return repository.bestPokemonByCp(pageable);
    }
}
