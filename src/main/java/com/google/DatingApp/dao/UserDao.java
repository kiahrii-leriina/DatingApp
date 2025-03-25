package com.google.DatingApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.DatingApp.entity.User;
import com.google.DatingApp.entity.UserRole;
import com.google.DatingApp.entity.UserStatus;
import com.google.DatingApp.repository.UserRepository;
import com.google.DatingApp.util.UserGender;

@Repository
public class UserDao  {
	@Autowired
	private UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return repo.findByEmail(email);
	}

	public List<User> fetchAll() {
		return repo.findAll();
	}

	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}

	public Optional<List<User>> findByName(String name) {
		return repo.findByName(name);
	}

	public List<User> findAllMaleUsers(UserGender male) {
		return repo.findByGender(male);
	}

	public List<User> findAllFemaleUsers(UserGender female) {
		return repo.findByGender(female);
	}

	public List<User> findActiveMaleUsers(UserGender male, UserStatus active) {
		return repo.findByGenderAndStatus(male,active);
	}

	public List<User> findActiveFemaleUsers(UserGender female, UserStatus active) {
		return repo.findByGenderAndStatus(female,active);
	}

	public List<User> findMaleUsersByAge(UserGender male, int age1, int age2) {
		return repo.findByGenderAndAgeBetween(male,age1,age2);
	}

	public List<User> findFemaleUsersByAge(UserGender female, int age1, int age2) {
		return repo.findByGenderAndAgeBetween(female,age1,age2);
	}

	public List<User> findByRole(UserRole role) {

		return repo.findByRole(role);
	}

	public List<User> findUserByStatus(UserStatus status) {
		return repo.findByStatus(status);
	}

	public List<User> findByGender(UserGender gender) {
		return repo.findByGender(gender);
	}

	public void deleteUser(Long id) {
		repo.deleteById(id);
	}

	
}








