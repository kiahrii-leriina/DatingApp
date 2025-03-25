package com.google.DatingApp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.google.DatingApp.dao.UserDao;
import com.google.DatingApp.dto.MatchingUser;
import com.google.DatingApp.entity.User;
import com.google.DatingApp.entity.UserRole;
import com.google.DatingApp.entity.UserStatus;
import com.google.DatingApp.exceptionclasses.DuplicateEmailException;
import com.google.DatingApp.exceptionclasses.InvalidIDException;
import com.google.DatingApp.exceptionclasses.InvalidOTPException;
import com.google.DatingApp.exceptionclasses.NoUserFoundException;
import com.google.DatingApp.responseStructure.ResponseStructure;
import com.google.DatingApp.util.EmailService;
import com.google.DatingApp.util.SortByAgeDefferenceInAcending;
import com.google.DatingApp.util.UserGender;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	@Autowired
	private EmailService emailService;

	public ResponseStructure<User> saveUser(User user) {
		user.setStatus(UserStatus.INACTIVE);
		int otp = emailService.getOTP();
		user.setOtp(otp);

		Optional<User> opt = dao.findByEmail(user.getEmail());

		if (opt.isPresent()) {
			throw new DuplicateEmailException("Account Already Exist with the given Email" + user.getEmail());
		}

		User saveUser = dao.saveUser(user);
		
		emailService.sendFirstEmail(saveUser);
		
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("user saved successfully");
		rs.setBody(saveUser);
		return rs;

	}

	public ResponseStructure<List<User>> fetchAll() {
		List<User> users = dao.fetchAll();
		ResponseStructure<List<User>> rs = new ResponseStructure<>();

		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("user saved successfully");
		rs.setBody(users);
		return rs;
	}

	public ResponseStructure<User> findById(Long id) {
		Optional<User> optional = dao.findById(id);

		if (optional.isEmpty()) {
			throw new InvalidIDException(" No user found With the given id " + id);
		}
		User user = optional.get();
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage(" user found ");
		rs.setBody(user);
		return null;
	}

	public ResponseStructure<List<User>> findByName(String name) {
		Optional<List<User>> optional = dao.findByName(name);

		if (optional.isEmpty()) {
			throw new NoUserFoundException("No user found with the given name " + name);
		}
		List<User> user = optional.get();

		ResponseStructure<List<User>> rs = new ResponseStructure<>();

		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("users with the name " + name);
		rs.setBody(user);
		return rs;
	}

	public ResponseStructure<List<User>> findAllMaleUsers() {
		List<User> maleUsers = dao.findAllMaleUsers(UserGender.MALE);
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("List of male users");
		rs.setBody(maleUsers);
		return rs;
	}

	public ResponseStructure<List<User>> findAllFemaleUsers() {
		List<User> femaleUsers = dao.findAllFemaleUsers(UserGender.FEMALE);
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("List of Female users");
		rs.setBody(femaleUsers);
		return rs;
	}

	public ResponseStructure<List<User>> findActiveMale() {
		List<User> amu = dao.findActiveMaleUsers(UserGender.MALE, UserStatus.ACTIVE);

		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("All active male users");
		rs.setBody(amu);
		return rs;
	}

	public ResponseStructure<List<User>> findActiveFemale() {
		List<User> afu = dao.findActiveFemaleUsers(UserGender.FEMALE, UserStatus.ACTIVE);

		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("All active female users");
		rs.setBody(afu);
		return rs;
	}

	public ResponseStructure<List<User>> findMaleUsersByAge(int age1, int age2) {
		List<User> maleusers = dao.findMaleUsersByAge(UserGender.MALE, age1, age2);
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Male users between the age of " + age1 + " and " + age2);
		rs.setBody(maleusers);
		return rs;
	}

	public ResponseStructure<List<User>> findFemaleUserwithAge(int age1, int age2) {

		List<User> femaleusers = dao.findFemaleUsersByAge(UserGender.FEMALE, age1, age2);
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Female users between the age of " + age1 + " and " + age2);
		rs.setBody(femaleusers);
		return rs;
	}

	public ResponseStructure<List<User>> findByRole(UserRole role) {
		List<User> users = dao.findByRole(role);

		if (users.isEmpty()) {
			throw new NoUserFoundException("No user found with the given role " + role);
		}

		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("list of " + role + " user");
		rs.setBody(users);
		return rs;
	}

	public ResponseStructure<User> setUserStatusInactive(Long id) {

		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException(" No user found With the given id " + id + " unable to set user status");
		}
		User user = byId.get();
		user.setStatus(UserStatus.INACTIVE);
		User saveUser = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("User Status set to " + UserStatus.INACTIVE + " successfully");
		rs.setBody(saveUser);
		return rs;
	}

	public ResponseStructure<User> setUserStatusBlocked(Long id) {
		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException("No user found with id no " + id + " unable to set user status");
		}
		User user = byId.get();
		user.setStatus(UserStatus.BLOCKED);
		User saveUser = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("User Status Set to " + UserStatus.BLOCKED + " successfully");
		rs.setBody(saveUser);
		return rs;
	}

	public ResponseStructure<User> setUserStatusDelete(Long id) {
		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException("No user found with id no " + id + " unable to set user status");
		}
		User user = byId.get();
		user.setStatus(UserStatus.DELETED);
		User saveUser = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("User Status Set to " + UserStatus.DELETED + " successfully");
		rs.setBody(saveUser);
		return rs;
	}

	public ResponseStructure<User> setUserStatusTerminate(Long id) {
		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException("No user found with id no " + id + " unable to set user status");
		}
		User user = byId.get();
		user.setStatus(UserStatus.TERMINATED);
		User saveUser = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("User Status Set to " + UserStatus.TERMINATED + " successfully");
		rs.setBody(saveUser);
		return rs;
	}

	public ResponseStructure<User> setUserStatusActive(Long id) {
		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException("No user found with id no " + id + " unable to set user status");
		}
		User user = byId.get();
		user.setStatus(UserStatus.ACTIVE);
		User saveUser = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("User Status Set to " + UserStatus.ACTIVE + " successfully");
		rs.setBody(saveUser);
		return rs;
	}

	public ResponseStructure<List<User>> findUserByStatus(UserStatus status) {
		List<User> users = dao.findUserByStatus(status);
		if (users.isEmpty()) {
			throw new NoUserFoundException(" NO user found with status " + status);
		}
		ResponseStructure<List<User>> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("list of user with status " + status);
		rs.setBody(users);
		return rs;
	}

	public ResponseStructure<List<MatchingUser>> findAllMatchingUsers(Long id, Integer top) {
		Optional<User> byId = dao.findById(id);
		if (byId.isEmpty()) {
			throw new InvalidIDException(" no user found with the given ID " + id + ", unable to find top matches");	
		}
		User user = byId.get();
		UserGender gender = user.getGender();
//		System.out.println(gender);
		List<User> users = new ArrayList<>();
		if(gender.equals(UserGender.MALE)) {
			users = dao.findByGender(UserGender.FEMALE);
		}
		else {
			users = dao.findByGender(UserGender.MALE);
		}
		
//		System.out.println("list of opposite gender users /n");
//		printCollection(users);
		List<MatchingUser>matchingUsers = new ArrayList<>();
		for(User u: users) {	
			MatchingUser mu = new MatchingUser();
			mu.setName(u.getName());
			mu.setAge(u.getAge());
			mu.setGender(u.getGender());
			mu.setInterest(u.getInterest());
			mu.setAgeDifference(Math.abs(user.getAge()-u.getAge()));
			mu.setMatchingInterestCount(countInterest(user.getInterest(), u.getInterest()));
			matchingUsers.add(mu);
			
		}	
	System.out.println("=======================================printng collection=======================================");	
	printCollection(matchingUsers);
	Collections.sort(matchingUsers,new SortByAgeDefferenceInAcending());
	System.out.println("===================================== after sorting ======================================");
	printCollection(matchingUsers);
	matchingUsers = matchingUsers.stream().limit(top).collect(Collectors.toList());
	System.out.println(" top "+top+" matching users");
	printCollection(matchingUsers);

		return new ResponseStructure<List<MatchingUser>>(HttpStatus.OK.value(),"List of matching users",matchingUsers);
	}

	private int countInterest(List<String> list1, List<String> list2) {
		int c = 0;
		for(String s: list1) {
			if(list2.contains(s))
				c++;
		}
		return c;
	}

	private void printCollection(Collection c) {

		for(Object o:c) {
			System.out.println(o);
		}
	}

	public ResponseStructure<User> deleteUser(Long id) {
		
		Optional<User> byId = dao.findById(id);
		if(byId.isEmpty()) {
			throw new InvalidIDException("user with id "+id +" not found");
		}
		dao.deleteUser(id);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("user deleted successfully");
		rs.setBody(null);
		return rs;
	}

	public ResponseStructure<User> verifyOtp(Long id, int otp) {
		Optional<User> byId = dao.findById(id);
		
		if(byId.isEmpty()) {
			throw new InvalidOTPException("user with id "+id +" not found");
		}
		
		User user = byId.get();
		
		System.out.println("user otp "+otp);
		if(otp != user.getOtp()) {
			throw new InvalidOTPException("invalid otp");
		}
		user.setStatus(UserStatus.ACTIVE);
		user = dao.saveUser(user);
		ResponseStructure<User> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("user account set to active");
		rs.setBody(user);
		
		return rs;
	}

	

}
