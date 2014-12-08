package newTestGui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import newTestDAO.DBHandler;
import newTestDomain.Booking;

public class AddClientPanel implements ActionListener {
	
	private JLabel gnum, snum, cotnum, datFr, datTo;
	private JTextField gnumT, snumT, datFrT, datToT;
	private JComboBox cotnumCB;
	private JButton save;
	private JFrame frame;
	
	public AddClientPanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Make Reservation");
		frame.setSize(700, 120);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new GridLayout(2, 6));
		gnum = new JLabel("Guest Number");
		center.add(gnum);
		gnumT = new JTextField(2);
		center.add(gnumT);
		snum = new JLabel("Staff Number");
		center.add(snum);
		snumT = new JTextField(20);
		center.add(snumT);
//		lname = new JLabel("Last Name");
//		center.add(lname);
//		lnameT = new JTextField(20);
//		center.add(lnameT);
		cotnum = new JLabel("Cottage Number");
		center.add(cotnum);
		
		String[] cottageNums = { "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10", "11",
				"12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29",
				"30", "31", "32", "33"};
		cotnumCB = new JComboBox(cottageNums);
		center.add(cotnumCB);
		
		datFr = new JLabel("From week");
		center.add(datFr);
		datFrT = new JTextField(20);
		center.add(datFrT);
		datTo = new JLabel("Week Number");
		center.add(datTo);
		datToT = new JTextField(20);
		center.add(datToT);
		
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
			String gn1 = gnumT.getText();
			int gn = Integer.parseInt(gn1);
			String sn1 = snumT.getText();
			int sn = Integer.parseInt(sn1);
			String cn1 = (String) cotnumCB.getSelectedItem();
			int cn = Integer.parseInt(cn1);
			String df1 = datFrT.getText();
			int df = Integer.parseInt(df1);
			String dt1 = datToT.getText();
			int dt = Integer.parseInt(dt1);
			Booking b = new Booking(gn, sn, cn, df, dt);
			DBHandler insert = new DBHandler();
			insert.insertBooking(b);
		}
	}

}
