package me.web.sweet.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.cert.CertPathBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class AdminUser extends User{

    @Builder
    public AdminUser(Long id, LocalDateTime registeredAt, String name, String email, String password, LocalDate birthDate, String address, String city, String country, String telephone) {
        super(id, registeredAt, name, email, password, birthDate, address, city, country, telephone);

    }
}
