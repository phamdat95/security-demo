package com.example.bootemo.repository;

import com.example.bootemo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}
