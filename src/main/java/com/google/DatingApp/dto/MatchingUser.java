package com.google.DatingApp.dto;

import java.util.List;

import com.google.DatingApp.util.UserGender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MatchingUser {
	private String name;
	private Integer age;
	private UserGender gender;
	private List<String> interest;
	private int ageDifference;
	private int matchingInterestCount;
	
}
