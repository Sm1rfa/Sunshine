package newTestGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class OwnerPanel implements ActionListener {
	
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu ctg, resrv, hlp, abt, staff, guest;
	private JMenuItem vw, fr, inf, hlp1, abt1, stf, guest1;
    private JComponent content, content2, content3, content4;


	public OwnerPanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sunshine Resort");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null); // centre on screen
		
		menuBar = new JMenuBar();
		
		staff = new JMenu("Staff");
		menuBar.add(staff);
		stf = new JMenuItem("Manage staff");
		stf.addActionListener(this);
		staff.add(stf);
		
		ctg = new JMenu("Cottage");
		menuBar.add(ctg);
		vw = new JMenuItem("Manage Cottages");
		vw.addActionListener(this);
		fr = new JMenuItem("Free");
		//fr.addActionListener(this);
		ctg.add(vw);
		ctg.add(fr);
		
		resrv = new JMenu("Booking");
		menuBar.add(resrv);
		inf = new JMenuItem("Details");
		inf.addActionListener(this);
		resrv.add(inf);
		
		guest = new JMenu("Guest");
		menuBar.add(guest);
		guest1 = new JMenuItem("Manage Guests");
		guest1.addActionListener(this);
		guest.add(guest1);
		
		hlp = new JMenu("Help");
		menuBar.add(hlp);
		hlp1 = new JMenuItem("Using");
		hlp1.addActionListener(this);
		hlp.add(hlp1);
		
		abt = new JMenu("About us");
		menuBar.add(abt);
		abt1 = new JMenuItem("Creators");
		abt1.addActionListener(this);
		abt.add(abt1);
     
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == abt1)
			JOptionPane.showMessageDialog(null, "This is a school project for KEA \n created by Stoyan Bonchev - Sm1rfa \n " +
					"For more information write to contact@sm1rfa.usr.me");
		if(e.getSource() == hlp1)
			JOptionPane.showMessageDialog(null, "You can read the manual for more explenations or" +
					"\n just write to contact@sm1rfa.usr.me");
		if(e.getSource() == inf) {
		    if (content != null)
		        frame.getContentPane().remove(content);
		    	content = new ReservPanel();
		    	frame.getContentPane().add(content, BorderLayout.CENTER);
		    	frame.getContentPane().revalidate();
		}
		if(e.getSource() == vw) {
			if(content2 != null)
	        	frame.getContentPane().remove(content2);
	        	content2 = new ManageCottagePanel();
	        	frame.getContentPane().add(content2, BorderLayout.CENTER);
	        	frame.getContentPane().revalidate();
		}
		if(e.getSource() == stf) {
			if(content3 != null)
	        	frame.getContentPane().remove(content3);
	        	content3 = new ManageStaffPanel();
	        	frame.getContentPane().add(content3, BorderLayout.CENTER);
	        	frame.getContentPane().revalidate();
		}
		if(e.getSource() == guest1) {
			if(content4 != null)
	        	frame.getContentPane().remove(content4);
	        	content4 = new ManageGuests();
	        	frame.getContentPane().add(content4, BorderLayout.CENTER);
	        	frame.getContentPane().revalidate();
		}
	}
}
