package newTestGui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import newTestDAO.DBGuestHandler;
import newTestDomain.Address;
import newTestDomain.Guest;

public class AddGuest implements ActionListener {
	
	private JLabel fname, lname, street, zip, city1, country1;
	private JTextField fnameT, lnameT, streetT, zipT, city1T, country1T;
	private JButton save;
	private JFrame frame;
	
	public AddGuest() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Make Reservation");
		frame.setSize(700, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new GridLayout(6, 1));
		fname = new JLabel("First Name");
		center.add(fname);
		fnameT = new JTextField(20);
		center.add(fnameT);
		lname = new JLabel("Last Name");
		center.add(lname);
		lnameT = new JTextField(20);
		center.add(lnameT);
		
		street = new JLabel("Street");
		center.add(street);
		streetT = new JTextField(20);
		center.add(streetT);
		zip = new JLabel("Zip");
		center.add(zip);
		zipT = new JTextField(20);
		center.add(zipT);
		
		city1 = new JLabel("City");
		center.add(city1);
		city1T = new JTextField(20);
		center.add(city1T);
		country1 = new JLabel("Country");
		center.add(country1);
		country1T = new JTextField(20);
		center.add(country1T);
		
		frame.add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new GridLayout(0, 6));
		save = new JButton("Save");
		save.setSize(15, 15);
		south.add(save);
		save.addActionListener(this);
		
		frame.add(south, BorderLayout.SOUTH);
		
		
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			
			String fn = fnameT.getText();
			String ln = lnameT.getText();
			String str = streetT.getText();
			String pc = zipT.getText();
			String cit = city1T.getText();
			String cou = country1T.getText();
			Address a = new Address(pc, cit, cou);
			Guest g = new Guest(fn, ln, str, pc);
			DBGuestHandler insert = new DBGuestHandler();
			insert.insertAddress(a);
			insert.insertGuest(g);

		}
	}

}
