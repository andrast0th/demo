package com.example.demo.api;

import com.example.demo.api.model.RoleConstants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

import static com.example.demo.security.SecurityConfiguration.ROLE_PREFIX;

@RestController
@RequestMapping("/role-test")
@AllArgsConstructor
public class RoleTestController {

    // Roles are from the db table, constants would be nice
    @RolesAllowed({RoleConstants.ADMIN})
    @GetMapping("admin-endpoint")
    public String getStuffForAdmin() {
        return "only admin should be able to call this.";
    }

    @RolesAllowed({RoleConstants.USER, RoleConstants.ADMIN})
    @GetMapping("user-endpoint")
    public String getStuffForNormalUser() {
        return "only a normal user should be able to call this.";
    }

}