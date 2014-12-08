package newTestDomain;

public class Staff {
	private int staffNO;
	private String fName;
	private String lName;
	private String position;
	private String DOB;
	
	public Staff(int staffNO, String fName, String lName, String position, String DOB) {
		this.fName = fName;
		this.lName = lName;
		this.position = position;
		this.DOB = DOB;
	}
	
	public Staff(String fName, String lName, String position, String DOB) {
		this.fName = fName;
		this.lName = lName;
		this.position = position;
		this.DOB = DOB;
	}
	
	public int getstaffNO() {
		return staffNO;
	}
	
	public void setstaffNO(int staffNO) {
		this.staffNO = staffNO;
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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

}
