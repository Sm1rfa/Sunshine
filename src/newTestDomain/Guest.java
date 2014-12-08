package newTestDomain;

public class Guest {
	private int guestNO;
	private String fName;
	private String lName;
	private String streetName;
	private String postCode;
	private String city;
	private String email;
	
	
	public Guest(int guestNO, String fName, String lName, String streetName,
			String postCode) {
		this.guestNO = guestNO;
		this.fName = fName;
		this.lName = lName;
		this.streetName = streetName;
		this.postCode = postCode;
//		this.city = city;
//		this.email = email;
	}
	
	public Guest(String fname, String lname, String streetName, String postCode) {
		this.fName = fname;
		this.lName = lname;
		this.streetName = streetName;
		this.postCode = postCode;
	}
	
	public int getGuestNO() {
		return guestNO;
	}
	public void setGuestNO(int guestNO) {
		this.guestNO = guestNO;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
