package com.javacorner.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacorner.admin.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
