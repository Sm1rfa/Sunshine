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

import newTestDAO.DBStaffHandler;
import newTestDomain.Staff;

public class AddStaffPanel implements ActionListener {
	
	private JLabel dob, fname, lname, posit;
	private JTextField dobT, fnameT, lnameT;
	private JComboBox positCB;
	private JButton save;
	private JFrame frame;
	
	public AddStaffPanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Add Staff");
		frame.setSize(700, 150);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new GridLayout(4, 8));
		dob = new JLabel("Date of birth");
		center.add(dob);
		dobT = new JTextField(2);
		center.add(dobT);
		fname = new JLabel("First Name");
		center.add(fname);
		fnameT = new JTextField(20);
		center.add(fnameT);
		lname = new JLabel("Last Name");
		center.add(lname);
		lnameT = new JTextField(20);
		center.add(lnameT);
		posit = new JLabel("Position");
		center.add(posit);
		
		String[] staffPos = { "Receptionist", "Accountant", "Housekeeper", "Security"};
		positCB = new JComboBox(staffPos);
		center.add(positCB);
		
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
			String pos = (String) positCB.getSelectedItem();
			String dob = dobT.getText();
			Staff s = new Staff(fn, ln, pos, dob);
			DBStaffHandler insert = new DBStaffHandler();
			insert.insertStaff(s);
		}
	}

}
