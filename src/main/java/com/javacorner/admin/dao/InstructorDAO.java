package com.javacorner.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacorner.admin.entity.Instructor;

public interface InstructorDAO extends JpaRepository<Instructor, Long> {

}
