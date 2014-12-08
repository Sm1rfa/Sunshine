package newTestDomain;

public class Booking {
		private int bookingNO;
		private int staffNO;
		private int guestNO;
		private int cottageNO;
		private int dateFrom;
		private int dateTo;
		
		public Booking(int bookingNO, int staffNO, int guestNO, int cottageNO,
				int dateFrom, int dateTo) {
			this.bookingNO = bookingNO;
			this.staffNO = staffNO;
			this.guestNO = guestNO;
			this.cottageNO = cottageNO;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
		}
		
		public Booking(int staffNO, int guestNO, int cottageNO, int dateFrom, int dateTo) {
			this.staffNO = staffNO;
			this.guestNO = guestNO;
			this.cottageNO = cottageNO;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
		}
		
		public int getBookingNO() {
			return bookingNO;
		}
		public void setBookingNO(int bookingNO) {
			this.bookingNO = bookingNO;
		}
		public int getStaffNO() {
			return staffNO;
		}
		public void setStaffNO(int staffNO) {
			this.staffNO = staffNO;
		}
		public int getGuestNO() {
			return guestNO;
		}
		public void setGuestNO(int guestNO) {
			this.guestNO = guestNO;
		}
		public int getCottageNO() {
			return cottageNO;
		}
		public void setCottageNO(int cottageNO) {
			this.cottageNO = cottageNO;
		}
		public int getDateFrom() {
			return dateFrom;
		}
		public void setDateFrom(int dateFrom) {
			this.dateFrom = dateFrom;
		}
		public int getDateTo() {
			return dateTo;
		}
		public void setDateTo(int dateTo) {
			this.dateTo = dateTo;
		}
		
}
