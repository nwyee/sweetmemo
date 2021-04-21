package me.web.sweet.controllers;

import me.web.sweet.model.AdminUser;
import me.web.sweet.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admins")
@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String list(Model model) {
        model.addAttribute("admins", adminService.findAll());
        return "admins/index";
    }

    @RequestMapping("new")
    public String initCreate(Model model){
        model.addAttribute("admin", AdminUser.builder().build());
        return "admins/createOrUpdate";
    }

    @RequestMapping
    public String processFindForm(AdminUser admin, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (admin.getName() == null) {
            admin.setName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<AdminUser> results = adminService.findAllByNameStartsWith(admin.getName());

        if (results.isEmpty()) {
            // no user found
            result.rejectValue("name", "notFound", "not found");
            return "admins/find";
        } else if (results.size() == 1) {
            // 1 user found
            admin = results.get(0);
            return "redirect:/admins/" + admin.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "admins/list";
        }
    }
}
