package newTestDomain;

public class Cottage {
	private int cottageNO;
	private String cottageType;
	private int numberOfBeds;
	private String cottageStatus;
	private double cottagePrice;
	
	
	public Cottage(int cottageNO, String cottageType, int numberOfBeds,
			String cottageStatus, double cottagePrice) {
		this.cottageNO = cottageNO;
		this.cottageType = cottageType;
		this.numberOfBeds = numberOfBeds;
		this.cottageStatus = cottageStatus;
		this.cottagePrice = cottagePrice;
	}
	public int getCottageNO() {
		return cottageNO;
	}
	public void setCottageNO(int cottageNO) {
		this.cottageNO = cottageNO;
	}
	public String getCottageType() {
		return cottageType;
	}
	public void setCottageType(String cottageType) {
		this.cottageType = cottageType;
	}
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public String getCottageStatus() {
		return cottageStatus;
	}
	public void setCottageStatus(String cottageStatus) {
		this.cottageStatus = cottageStatus;
	}
	
	public double getCottagePrice() {
		return cottagePrice;
	}
	public void setCottagePrice(double cottagePrice) {
		this.cottagePrice = cottagePrice;
	}
	
}
