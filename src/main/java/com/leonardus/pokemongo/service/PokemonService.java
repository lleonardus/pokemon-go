package com.leonardus.pokemongo.service;

import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository repository;

    public List<Pokemon> findByParams(Specification<Pokemon> specification, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);

        return repository.findAll(specification, pageRequest).getContent();
    }

    public List<Pokemon> topAttackers(Specification<Pokemon> specification, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("atk").descending());

        return repository.findAll(specification, pageRequest).getContent();
    }

    public List<Pokemon> topDefenders(Specification<Pokemon> specification, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("def").descending());

        return repository.findAll(specification, pageRequest).getContent();
    }

    public List<Pokemon> bestPokemonByStatTotal(Specification<Pokemon> specification, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("statTotal").descending());

        return repository.findAll(specification, pageRequest).getContent();
    }

    public List<Pokemon> bestPokemonByCp(Specification<Pokemon> specification, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("cp40").descending());

        return repository.findAll(specification, pageRequest).getContent();
    }
}
