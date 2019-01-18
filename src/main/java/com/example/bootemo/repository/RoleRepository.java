package com.example.bootemo.repository;

import com.example.bootemo.model.Role;
import org.springframework.data.repository.CrudRepository;



public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}
