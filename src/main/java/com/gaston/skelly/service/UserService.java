package com.gaston.skelly.service;

import com.gaston.skelly.model.User;
import com.gaston.skelly.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    final
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    // create a new user
    public void createUser(User newUser){
        // set user role
        newUser.setRoles(List.of(new SimpleGrantedAuthority("ROLE_USER")));

        repository.insert(newUser);
        repository.save(newUser);
    }

    // return whether user exists
    public boolean userExists(String email){
        return repository.findOneByEmail(email) != null;
    }


}
