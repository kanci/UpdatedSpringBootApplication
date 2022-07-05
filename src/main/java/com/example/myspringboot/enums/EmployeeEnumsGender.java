package com.example.myspringboot.enums;

import com.example.myspringboot.exception.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum EmployeeEnumsGender {
	M("Male"), F("Female");
	
	private final String gender;
	
	//getters and setters for enum class
	EmployeeEnumsGender(String gender) {
		this.gender=gender;
	}
	
	String getGenderType() {
		return gender;
	}

    @Override
    public String toString() {
        return gender;
    }
    
    @JsonCreator
    public static EmployeeEnumsGender create (String value) throws EnumValidationException {
        if(value == null) {
            throw new EnumValidationException(value, "EmployeeEnumsGender");
        }
        for(EmployeeEnumsGender v : values()) {
            if(value.equals(v.getGenderType())) {
                return v;
            }
        }
        throw new EnumValidationException(value, "EmployeeEnumsGender");
    }
}