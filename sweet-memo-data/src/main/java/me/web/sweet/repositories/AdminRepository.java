package me.web.sweet.repositories;

import me.web.sweet.model.AdminUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<AdminUser, Long> {
    AdminUser findByName(String name);
    List<AdminUser> findAllByNameStartsWith(String name);
}
