package com.leonardus.pokemongo.repository;

import com.leonardus.pokemongo.entity.Pokemon;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String>, JpaSpecificationExecutor<Pokemon> {
    @Query("SELECT p FROM Pokemon p ORDER BY p.atk DESC")
    List<Pokemon> topAttackers(Pageable pageable);

    @Query("SELECT p FROM Pokemon p ORDER BY p.def DESC")
    List<Pokemon> topDefenders(Pageable pageable);

    @Query("SELECT p FROM Pokemon p ORDER BY p.statTotal DESC")
    List<Pokemon> bestPokemonByStatTotal(Pageable pageable);

    @Query("SELECT p FROM Pokemon p ORDER BY p.cp40 DESC")
    List<Pokemon> bestPokemonByCp(Pageable pageable);
}
