package com.nissan.training.advancedjava.beans;

import java.io.Serializable;

public class RegistrationBean implements Serializable{
		private String fullName;
		private String email;
		private String password;
		private String phoneNumber;
	
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getFullName() {
			return fullName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmail() {
			return email;
		}
}