package com.google.DatingApp.entity;

import java.util.List;

import com.google.DatingApp.util.UserGender;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		private Integer age;
		private String email;
		private Long phone;
		private String password;
		private int otp;
		
		@Enumerated(EnumType.STRING)
		private UserGender gender;
		
		@Enumerated(EnumType.STRING)
		private UserRole role = UserRole.USER;
		
		@Enumerated(EnumType.STRING)
		private UserStatus status = UserStatus.INACTIVE;
		
		
		//ElementCollection is used when the associated type is not entity and it can be used only with list
		@ElementCollection     
		private List<String> interest;
		
		
		
}
