package com.example.individual_assignment_it_security.repository;


import com.example.individual_assignment_it_security.model.Role;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {

    Role findByName(String name);
}
