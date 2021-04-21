package me.web.sweet.services;

import me.web.sweet.model.AdminUser;

import java.util.List;

public interface AdminService extends CrudService<AdminUser, Long> {
    AdminUser findByName(String name);
    List<AdminUser> findAllByNameStartsWith(String prefixName);
}
