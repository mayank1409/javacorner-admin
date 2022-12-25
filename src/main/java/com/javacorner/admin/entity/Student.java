package com.javacorner.admin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID", nullable = false)
	private Long studentId;

	@Basic
	@Column(name = "FIRST_NAME", nullable = false, length = 45)
	private String firstName;

	@Basic
	@Column(name = "LAST_NAME", nullable = false, length = 45)
	private String lastName;

	@Basic
	@Column(name = "LEVEL", nullable = false, length = 64)
	private String level;

	@ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
	private Set<Course> courses = new HashSet<>();

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
	private User user;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, firstName, lastName, level, studentId, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(level, other.level)
				&& Objects.equals(studentId, other.studentId) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentId=").append(studentId).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", level=").append(level).append("]");
		return builder.toString();
	}

}