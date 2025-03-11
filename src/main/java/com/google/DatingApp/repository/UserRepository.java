package com.google.DatingApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.google.DatingApp.entity.User;
import com.google.DatingApp.entity.UserRole;
import com.google.DatingApp.entity.UserStatus;
import com.google.DatingApp.util.UserGender;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	public Optional<User> findByEmail(String email);

	public Optional<List<User>> findByName(String name);

	public List<User> findByGender(UserGender gender);

	public List<User> findByGenderAndStatus(UserGender gender, UserStatus status);

	public List<User> findByGenderAndAgeBetween(UserGender gender, int age1, int age2);
	
	
	@Query("select u from User u where u.role = :role")
	public List<User> findByRole(@Param("role") UserRole role);

	@Query("select u from User u where u.status = :status")
	public List<User> findByStatus(@Param("status") UserStatus status);


}
