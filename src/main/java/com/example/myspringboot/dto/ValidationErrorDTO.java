package com.example.myspringboot.dto;

//more notably error message for enum class, this exact error message should come like this

public class ValidationErrorDTO {
	private String enumName;
	private String enumValue;
	private String errorMessage;
	
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public String getEnumValue() {
		return enumValue;
	}
	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}