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

import newTestDAO.DBGuestHandler;
import newTestDomain.Guest;

public class ManageGuests extends JPanel implements ActionListener {
	
	private JButton adg, rmg, refr;


	public ManageGuests() {

		String[] guestInfo = {
				"GuestNO",
				"First Name",
				"Last Name",
				"Street name",
				"Post code"
		};
		
		Object[ ][ ] data;
		DBGuestHandler dbg = new DBGuestHandler();
		int size = dbg.getGuests().size();
		
		
		data = new Object[size][];
		int counter = 0;
		for (Guest g : dbg.getGuests()) {
			data[counter] = new Object[] {g.getGuestNO(), g.getfName(), g.getlName(), g.getStreetName(), g.getPostCode() };			
			counter++;
		}
        JTable tb = new JTable(data, guestInfo);
		
		JScrollPane sp = new JScrollPane(tb);
		tb.setFillsViewportHeight(true);
		
		adg = new JButton();
		adg.setText("Add");
		adg.addActionListener(this);
		rmg = new JButton();
		rmg.setText("Remove");
		rmg.addActionListener(this);
		refr = new JButton();
		refr.setText("Refresh");
		//refr.addActionListener(this);

		// Set our layout
		setLayout(new GridBagLayout());
		// add button on 0:0
		this.add(adg, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// remove button on 0:1
		this.add(rmg, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		//refresh button on 0:1
		this.add(refr, new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// table scroll on 1:0 (width 2)
		this.add(sp, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,       new Insets(0, 0, 0, 0), 0, 0));
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == adg)
			new AddGuest();
//		if(e.getSource() == rmg) {}
		if(e.getSource() == refr) {
			
		}
	}
}
