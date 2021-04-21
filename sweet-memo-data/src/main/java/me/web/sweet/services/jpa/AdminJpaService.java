package me.web.sweet.services.jpa;

import me.web.sweet.model.AdminUser;
import me.web.sweet.repositories.AdminRepository;
import me.web.sweet.services.AdminService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AdminJpaService implements AdminService {

    private final AdminRepository adminRepository;

    public AdminJpaService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminUser findByName(String name) {
        return adminRepository.findByName(name);
    }

    @Override
    public List<AdminUser> findAllByNameStartsWith(String prefixName) {
        return adminRepository.findAllByNameStartsWith(prefixName);
    }

    @Override
    public Set<AdminUser> findAll() {
        Set<AdminUser> admins = new HashSet<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    @Override
    public AdminUser findById(Long aLong) {
        return adminRepository.findById(aLong).orElse(null);
    }

    @Override
    public AdminUser save(AdminUser object) {
        return adminRepository.save(object);
    }

    @Override
    public void delete(AdminUser object) {
        adminRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepository.deleteById(aLong);
    }
}
