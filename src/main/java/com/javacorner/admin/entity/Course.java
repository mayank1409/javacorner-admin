package com.javacorner.admin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
	private Long courseId;

	@Basic
	@Column(name = "COURSE_NAME", nullable = false, length = 45, unique = true)
	private String courseName;

	@Lob
	@Column(name = "COURSE_DESCRIPTION", nullable = false)
	private String courseDescription;

	@Basic
	@Column(name = "COURSE_DURATION", nullable = false, length = 45)
	private String courseDuration;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ENROLLED_IN", joinColumns = { @JoinColumn(name = "COURSE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STUDENT_ID") })
	private Set<Student> students = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSTRUCTOR_ID", referencedColumnName = "INSTRUCTOR_ID", nullable = false)
	private Instructor instructor;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void assignStudentToCourse(Student student) {
		this.students.add(student);
		student.getCourses().add(this);
	}

	public void removeStudentFromCourse(Student student) {
		this.students.remove(student);
		student.getCourses().remove(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseDescription, courseDuration, courseId, courseName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseDescription, other.courseDescription)
				&& Objects.equals(courseDuration, other.courseDuration) && Objects.equals(courseId, other.courseId)
				&& Objects.equals(courseName, other.courseName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [courseId=").append(courseId).append(", courseName=").append(courseName)
				.append(", courseDescription=").append(courseDescription).append(", courseDuration=")
				.append(courseDuration).append("]");
		return builder.toString();
	}

}
