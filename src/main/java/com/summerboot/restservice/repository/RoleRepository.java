package com.summerboot.restservice.repository;

import com.summerboot.restservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository<Role, String> Role是实体，String是主键
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
