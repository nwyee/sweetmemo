package me.web.sweet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "tags")
public class Tag extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name="recipe_tags", joinColumns = @JoinColumn(name="tag_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id"))
    Set<Recipe> recipeSet;
}
