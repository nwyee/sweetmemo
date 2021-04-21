package me.web.sweet.init;

import me.web.sweet.model.AdminUser;
import me.web.sweet.services.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AdminService adminService;

    public DataInitializer(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = adminService.findAll().size();
        if(count == 0) {
            initData();
        }
    }

    private void initData() {
        AdminUser user = new AdminUser();
        user.setEmail("nan@gmail.com");
        user.setName("nan");
        user.setPassword("p@ssw0rd");
        adminService.save(user);

        System.out.println("Admins : " + adminService.findAll().size() + " rows loaded");
    }
}
