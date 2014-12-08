package newTestDomain;

import java.util.Date;

public class Payment {
	private int paymentNO;
	private int guestNO;
	private int staffNO;
	private double amount;
	private Date paymentDate;
	private int bookingNO;
	
	
	public Payment(int paymentNO, int guestNO, int staffNO, double amount,
			Date paymentDate, int bookingNO) {
		this.paymentNO = paymentNO;
		this.guestNO = guestNO;
		this.staffNO = staffNO;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.bookingNO = bookingNO;
	}
	public int getPaymentNO() {
		return paymentNO;
	}
	public void setPaymentNO(int paymentNO) {
		this.paymentNO = paymentNO;
	}
	public int getGuestNO() {
		return guestNO;
	}
	public void setGuestNO(int guestNO) {
		this.guestNO = guestNO;
	}
	public int getStaffNO() {
		return staffNO;
	}
	public void setStaffNO(int staffNO) {
		this.staffNO = staffNO;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getBookingNO() {
		return bookingNO;
	}
	public void setBookingNO(int bookingNO) {
		this.bookingNO = bookingNO;
	}
	
}
