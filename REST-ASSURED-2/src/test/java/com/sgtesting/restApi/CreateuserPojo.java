package com.sgtesting.restApi;

public class CreateuserPojo {
	
		private String email;
	    private String first_name;
	    private String last_name;
	    private String phone_number;
	    private String address;
	    private String state;
	    private String zipcode;
		public String getEmail() {
			return email;
		}
		public CreateuserPojo(String email, String first_name, String last_name, String phone_number, String address,
				String state, String zipcode) {
			super();
			this.email = email;
			this.first_name = first_name;
			this.last_name = last_name;
			this.phone_number = phone_number;
			this.address = address;
			this.state = state;
			this.zipcode = zipcode;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
	    
	    

}
