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

import newTestDAO.DBStaffHandler;
import newTestDomain.Staff;

public class ManageStaffPanel extends JPanel implements ActionListener {
	
	private JButton ads, rms, refr;


	public ManageStaffPanel() {

		String[] staffTb = {
				"Staff N#",
				"First Name",
				"Last Name",
				"Position"
		};
		
		Object[ ][ ] data2;
		DBStaffHandler dbs = new DBStaffHandler();
		int size = dbs.getStaff().size();
		
		data2 = new Object[size][];
		int counter = 0;
		for(Staff s : dbs.getStaff()) {
			data2[counter] = new Object[] {s.getstaffNO(), s.getfName(), s.getlName(), s.getPosition()};
			counter++;
		}
		DefaultTableModel stftbm = new DefaultTableModel(data2, staffTb);
        JTable tb2 = new JTable(stftbm);
		
		JScrollPane sp2 = new JScrollPane(tb2);
		tb2.setFillsViewportHeight(true);
		
		ads = new JButton();
		ads.setText("Add");
		ads.addActionListener(this);
		rms = new JButton();
		rms.setText("Remove");
		//rms.addActionListener(this);
		refr = new JButton();
		refr.setText("Refresh");
		//refr.addActionListener(this);

		// Set our layout
		setLayout(new GridBagLayout());
		// add button on 0:0
		this.add(ads, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// remove button on 0:1
		this.add(rms, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// refresh button on 0:2
		this.add(refr, new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// table scroll on 1:0 (width 2)
		this.add(sp2, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,       new Insets(0, 0, 0, 0), 0, 0));
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ads)
			new AddStaffPanel();
	}
}