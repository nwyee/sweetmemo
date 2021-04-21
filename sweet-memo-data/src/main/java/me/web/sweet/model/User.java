package me.web.sweet.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "telephone")
    private String telephone;


    public User(Long id, LocalDateTime registeredAt, String name, String email, String password, LocalDate birthDate, String address, String city, String country, String telephone) {
        super(id, registeredAt);
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
    }
}
