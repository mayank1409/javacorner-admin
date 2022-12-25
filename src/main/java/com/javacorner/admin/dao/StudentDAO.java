package com.javacorner.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacorner.admin.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Long> {

}
