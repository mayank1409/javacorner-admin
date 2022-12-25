package com.javacorner.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacorner.admin.entity.Course;

public interface CourseDAO extends JpaRepository<Course, Long> {

}
