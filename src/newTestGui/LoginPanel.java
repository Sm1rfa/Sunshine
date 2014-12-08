package newTestGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginPanel implements ActionListener {
	
	private JFrame frame;
	private JButton log, help;
	private JTextField username;
	private JPasswordField pass;
	private JLabel title;
	
	public LoginPanel() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("LogIN");
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new FlowLayout());
		title = new JLabel("Sunshine Resort", JLabel.CENTER);
		title.setFont(new Font("Sanserif", Font.BOLD, 20));
		north.add(title);
		frame.add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(3, 3));
		center.add(new JLabel("Username:"));
		username = new JTextField(20);
		center.add(username);
		center.add(new JLabel("Password:"));
		pass = new JPasswordField(20);
		center.add(pass);
		frame.add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new GridLayout(1, 3));
		log = new JButton();
		log.setText("Ok");
		log.setSize(15, 15);
		log.addActionListener(this);
		help = new JButton();
		help.setText("Help");
		help.setSize(15, 15);
		help.addActionListener(this);
		south.add(log);
		south.add(help);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		
		//String u = username.getText();
		
		if(e.getSource() == log)
			new OwnerPanel();
		if(e.getSource() == help)
			JOptionPane.showMessageDialog(null, "You can try to restart the program \n or you can contact me on contact@sm1rfa.usr.me");

	}

}
