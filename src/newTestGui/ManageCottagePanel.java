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

import newTestDAO.DBCottageHandler;
import newTestDomain.Cottage;

public class ManageCottagePanel extends JPanel implements ActionListener {
	
	private JButton adc, rmc, refr;


	public ManageCottagePanel() {

		String[] cottageTb = {
				"Cottage N#",
				"Type",
				"Beds",
				"Status",
				"Price"
		};
		
		Object[ ][ ] data1;
		DBCottageHandler dbc = new DBCottageHandler();
		int size = dbc.getCottage().size();
		
		data1 = new Object[size][];
		int counter = 0;
		for(Cottage c : dbc.getCottage()) {
			data1[counter] = new Object[] {c.getCottageNO(), c.getCottageType(), c.getNumberOfBeds(), c.getCottageStatus(), c.getCottagePrice()};
			counter++;
		}
		DefaultTableModel ctgtbm = new DefaultTableModel(data1, cottageTb);
        JTable tb1 = new JTable(ctgtbm);
		
		JScrollPane sp1 = new JScrollPane(tb1);
		tb1.setFillsViewportHeight(true);
		
		adc = new JButton();
		adc.setText("Add");
		adc.addActionListener(this);
		rmc = new JButton();
		rmc.setText("Remove");
		//rmv.addActionListener(this);
		refr = new JButton();
		refr.setText("Refresh");
		//refr.addActionListener(this);

		// Set our layout
		setLayout(new GridBagLayout());
		// add button on 0:0
		this.add(adc, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// remove button on 0:1
		this.add(rmc, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// refresh button on 0:2
		this.add(refr, new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		// table scroll on 1:0 (width 2)
		this.add(sp1, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,       new Insets(0, 0, 0, 0), 0, 0));
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == adc)
			new AddCottagePanel();
	}
}