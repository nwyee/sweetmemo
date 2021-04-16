package me.data.sweet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.data.sweet.model.type.Audience;
import me.data.sweet.model.type.Duration;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "direction", columnDefinition = "TEXT")
    private String direction;
    @Column(name = "prep_time")
    @Enumerated(EnumType.ORDINAL)
    private Duration prep;
    @Column(name = "cook_time")
    @Enumerated(EnumType.ORDINAL)
    private Duration cook_time;
    @Column(name = "audience")
    @Enumerated(EnumType.ORDINAL)
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private NormalUser author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "recipe_tags")
    Set<Tag> tagSet;

    @OneToMany(mappedBy = "recipes")
    Set<Ingredient> ingredientSet;

}
