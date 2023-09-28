package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    List<User> getUsers();

    User showUser(Long id);

    void deleteUser(Long id);

    void saveUser(User user);

}
