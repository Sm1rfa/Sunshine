package newTestGui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import newTestDAO.DBHandler;
import newTestDomain.Booking;

public class ReservPanel extends JPanel implements ActionListener {
	
	private JButton ad, rm, refr;


	public ReservPanel() {

		String[] columNames = {
				"Booking #",
				"Staff #",
				"Guest #",
				"Cottage #",
				"From week",
				"Weeks #"
		};
		Object[ ][ ] data;
		DBHandler dbb = new DBHandler();
		int size = dbb.getBooking().size();
		
		data = new Object[size][];
		int counter = 0;
		for(Booking b : dbb.getBooking()) {
			data[counter] = new Object[] {b.getBookingNO(), b.getStaffNO(), b.getGuestNO(), b.getCottageNO(), b.getDateFrom(), b.getDateTo()};
			counter++;
		}
		DefaultTableModel booktb = new DefaultTableModel(data, columNames);
        JTable tb = new JTable(booktb);
		
		JScrollPane sp = new JScrollPane(tb);
		tb.setFillsViewportHeight(true);
		
		
		ad = new JButton();
		ad.setText("Add");
		ad.addActionListener(this);
		rm = new JButton();
		rm.setText("Remove");
		//rmv.addActionListener(this);
		refr = new JButton();
		refr.setText("Refresh");
		//refr.addActionListener(this);

		// Set our layout
		setLayout(new GridBagLayout());
		// add button on 0:0
		this.add(ad, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// remove button on 0:1
		this.add(rm, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// refresh button on 0:2
		this.add(refr, new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// table scroll on 1:0 (width 2)
		this.add(sp, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,       new Insets(0, 0, 0, 0), 0, 0));
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ad)
			new AddClientPanel();
	}
}