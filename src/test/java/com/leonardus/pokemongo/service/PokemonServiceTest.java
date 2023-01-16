package com.leonardus.pokemongo.service;

import com.leonardus.pokemongo.controller.filter.PokemonParams;
import com.leonardus.pokemongo.entity.Pokemon;
import com.leonardus.pokemongo.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PokemonServiceTest {

    public static final int PAGE = 0;
    public static final int SIZE = 20;

    @InjectMocks
    PokemonService service;

    @Mock
    PokemonRepository repository;

    Specification<Pokemon> specification;
    PageRequest pageRequest;
    PageImpl<Pokemon> page;

    @BeforeEach
    void setUp() {
        specification = new PokemonParams().toSpec();
        pageRequest = PageRequest.of(PAGE, SIZE);
        page = new PageImpl<>(List.of(new Pokemon()));

        when(repository.findAll(specification, pageRequest)).thenReturn(page);
    }

    @Test
    @DisplayName("findByParams returns a list of pokémons")
    void findByParams() {
        List<Pokemon> response = service.findByParams(specification, PAGE, SIZE);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertNotNull(response.get(PAGE));
        assertEquals(new Pokemon(), response.get(0));
    }

    @Test
    @DisplayName("topAttackers returns a list of pokémons")
    void topAttackers() {
        pageRequest = PageRequest.of(PAGE, SIZE, Sort.by("atk").descending());
        when(repository.findAll(specification, pageRequest)).thenReturn(page);

        List<Pokemon> response = service.topAttackers(specification, PAGE, SIZE);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertNotNull(response.get(PAGE));
        assertEquals(new Pokemon(), response.get(0));
    }

    @Test
    @DisplayName("topDefenders returns a list of pokémons")
    void topDefenders() {
        pageRequest = PageRequest.of(PAGE, SIZE, Sort.by("def").descending());
        when(repository.findAll(specification, pageRequest)).thenReturn(page);

        List<Pokemon> response = service.topDefenders(specification, PAGE, SIZE);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertNotNull(response.get(0));
        assertEquals(new Pokemon(), response.get(0));
    }

    @Test
    @DisplayName("bestPokemonByStatTotal returns a list of pokémons")
    void bestPokemonByStatTotal() {
        pageRequest = PageRequest.of(PAGE, SIZE, Sort.by("statTotal").descending());
        when(repository.findAll(specification, pageRequest)).thenReturn(page);

        List<Pokemon> response = service.bestPokemonByStatTotal(specification, PAGE, SIZE);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertNotNull(response.get(0));
        assertEquals(new Pokemon(), response.get(0));
    }

    @Test
    @DisplayName("bestPokemonByCp returns a list of pokémons")
    void bestPokemonByCp() {
        pageRequest = PageRequest.of(PAGE, SIZE, Sort.by("cp40").descending());
        when(repository.findAll(specification, pageRequest)).thenReturn(page);

        List<Pokemon> response = service.bestPokemonByCp(specification, PAGE, SIZE);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertNotNull(response.get(0));
        assertEquals(new Pokemon(), response.get(0));
    }
}