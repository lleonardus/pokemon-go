package com.leonardus.pokemongo.controller.filter;

import com.leonardus.pokemongo.entity.Pokemon;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonParams {
    private String name;
    private String type;
    private Integer generation;
    private Boolean notGettable;
    private Integer familyId;
    private Boolean legendary;

    public Specification<Pokemon> toSpec(){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null){
                Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
                predicates.add(predicate);
            }
            if (type != null){
                Predicate predicate1 = criteriaBuilder.equal(criteriaBuilder.upper(root.get("type1")), type.toUpperCase());
                Predicate predicate2 = criteriaBuilder.equal(criteriaBuilder.upper(root.get("type2")), type.toUpperCase());
                Predicate predicate = criteriaBuilder.or(predicate1, predicate2);

                predicates.add(predicate);
            }
            if (generation != null){
                Predicate predicate = criteriaBuilder.equal(root.get("generation"), generation);
                predicates.add(predicate);
            }
            if (notGettable != null){
                Predicate predicate = criteriaBuilder.equal(root.get("notGettable"), notGettable);
                predicates.add(predicate);
            }
            if (familyId != null){
                Predicate predicate = criteriaBuilder.equal(root.get("familyId"), familyId);
                predicates.add(predicate);
            }
            if (legendary != null){
                Predicate predicate = criteriaBuilder.equal(root.get("legendary"), legendary);
                predicates.add(predicate);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
