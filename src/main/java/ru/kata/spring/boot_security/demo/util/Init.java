package ru.kata.spring.boot_security.demo.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initializedDataBase() {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));
        Set<Role> adminRole = new HashSet<>();
        Set<Role> userRole = new HashSet<>();
        Set<Role> allRoles = new HashSet<>();
        adminRole.add(roleService.showUserById(1L));
        userRole.add(roleService.showUserById(2L));
        allRoles.add(roleService.showUserById(1L));
        allRoles.add(roleService.showUserById(2L));
        userService.save(new User("Mike", "Pyke", 24, "pyke@mail.ru", "Pyke", adminRole));
        userService.save(new User("Piter", "Lombok", 34, "lombok@mail.ru", "Lombok", userRole));
        userService.save(new User("Kate", "Java", 44, "java@gmail.com", "Java", allRoles));
    }
}
