package com.google.DatingApp.util;

import java.util.Comparator;

import com.google.DatingApp.dto.MatchingUser;

public class SortByAgeDefferenceInAcending implements Comparator<MatchingUser>{

	@Override
	public int compare(MatchingUser o1, MatchingUser o2) {
		if(o1.getAgeDifference()<o2.getAgeDifference())
			return -1;
		else if(o1.getAgeDifference()>o2.getAgeDifference())	
			return 1;
		
		else {
			if(o1.getMatchingInterestCount()<o2.getMatchingInterestCount()) {
				return 1;
			}
			else if(o1.getMatchingInterestCount()>o2.getMatchingInterestCount()) {
				return -1;
			}
		}
		return 0;
	}

	
}
