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

import newTestDAO.DBCottageHandler;
import newTestDomain.Cottage;

public class AddCottagePanel implements ActionListener {
	
	private JLabel cnum, bnum, type, stat, price;
	private JTextField cnumT, bnumT, typeT, statT, priceT;
	private JButton save;
	private JFrame frame;
	
	public AddCottagePanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Add Cottage");
		frame.setSize(700, 120);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new GridLayout(3, 6));
		cnum = new JLabel("Cottage Number");
		center.add(cnum);
		cnumT = new JTextField(2);
		center.add(cnumT);
		bnum = new JLabel("Number of beds");
		center.add(bnum);
		bnumT = new JTextField(20);
		center.add(bnumT);
		type = new JLabel("Type");
		center.add(type);
		typeT = new JTextField(20);
		center.add(typeT);
		stat = new JLabel("Status");
		center.add(stat);
		statT = new JTextField(20);
		center.add(statT);
		price = new JLabel("Price");
		center.add(price);
		priceT = new JTextField(20);
		center.add(priceT);
		
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
			String cn1 = cnumT.getText();
			int cn = Integer.parseInt(cn1);
			String bn1 = bnumT.getText();
			int bn = Integer.parseInt(bn1);
			String type = typeT.getText();
			String status = statT.getText();
			String pr1 = priceT.getText();
			double pr = Double.parseDouble(pr1);
			Cottage c = new Cottage(cn, type, bn, status, pr);
			DBCottageHandler insert = new DBCottageHandler();
			insert.insertCottage(c);
		}
	}

}
