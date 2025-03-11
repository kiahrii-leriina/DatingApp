package com.google.DatingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.DatingApp.dto.MatchingUser;
import com.google.DatingApp.entity.User;
import com.google.DatingApp.entity.UserRole;
import com.google.DatingApp.entity.UserStatus;
import com.google.DatingApp.responseStructure.ResponseStructure;
import com.google.DatingApp.service.UserService;
import com.google.DatingApp.util.UserGender;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping
	public ResponseStructure<List<User>> fetchAllUser() {
		return service.fetchAll();
	}

	@GetMapping("/id/{id}")
	public ResponseStructure<User> findById(@PathVariable(name = "id") Long id) {
		return service.findById(id);
	}

	@GetMapping("name/{name}")
	public ResponseStructure<List<User>> findByName(@PathVariable(name = "name") String name) {
		return service.findByName(name);
	}

	@GetMapping("gender/male")
	public ResponseStructure<List<User>> findAllMaleUsers() {
		return service.findAllMaleUsers();

	}

	@GetMapping("gender/female")
	public ResponseStructure<List<User>> findAllFemaleUsers() {
		return service.findAllFemaleUsers();
	}

	@GetMapping("/status/male")
	public ResponseStructure<List<User>> findActiveMale() {
		return service.findActiveMale();
	}

	@GetMapping("/status/female")
	public ResponseStructure<List<User>> findActiveFemale() {
		return service.findActiveFemale();
	}

	@GetMapping("/male/age/{age1}/{age2}")
	public ResponseStructure<List<User>> findMaleUserwithAge(@PathVariable(name = "age1") int age1,
			@PathVariable(name = "age2") int age2) {
		return service.findMaleUsersByAge(age1, age2);

	}

	@GetMapping("/female/age/{age1}/{age2}")
	public ResponseStructure<List<User>> findFemaleUserwithAge(@PathVariable(name = "age1") int age1,
			@PathVariable(name = "age2") int age2) {
		return service.findFemaleUserwithAge(age1, age2);

	}

	@GetMapping("/role/{role}")
	public ResponseStructure<List<User>> findByRole(@PathVariable UserRole role) {
		return service.findByRole(role);
	}

	@PatchMapping("/status/inactive/{id}")
	public ResponseStructure<User> setUserStatusInactive(@PathVariable(name = "id") Long id) {
		return service.setUserStatusInactive(id);
	}

	@PatchMapping("/status/blocked/{id}")
	public ResponseStructure<User> setUserStatusBlocked(@PathVariable(name = "id") Long id) {
		return service.setUserStatusBlocked(id);
	}

	@PatchMapping("/status/deleted/{id}")
	public ResponseStructure<User> setUserStatusDelete(@PathVariable(name = "id") Long id) {
		return service.setUserStatusDelete(id);
	}

	@PatchMapping("/status/terminated/{id}")
	public ResponseStructure<User> setUserStatusTerminate(@PathVariable(name = "id") Long id) {
		return service.setUserStatusTerminate(id);
	}

	@PatchMapping("/status/active/{id}")
	public ResponseStructure<User> setUserStatusActive(@PathVariable(name = "id") Long id) {
		return service.setUserStatusActive(id);
	}

	@GetMapping("/status/{status}")
	public ResponseStructure<List<User>> findUserByStatus(@PathVariable(name = "status") UserStatus status) {
		return service.findUserByStatus(status);
	}

	@GetMapping("/matches/{id}/{top}/") // /users/matches/2/top 3 matching users
	public ResponseStructure<List<MatchingUser>> findAllMatchingUsers(@PathVariable(name = "id") Long id,
			@PathVariable(name = "top") Integer top) {

		return service.findAllMatchingUsers(id,top);
	}
}
