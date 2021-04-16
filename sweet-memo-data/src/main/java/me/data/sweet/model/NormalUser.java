package me.data.sweet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class NormalUser extends User{
    @Column( name = "about_me", columnDefinition = "TEXT")
    private String aboutMe;
    @Column( name = "facebook_link")
    private String facebookLink;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Recipe> recipeSet;

}
