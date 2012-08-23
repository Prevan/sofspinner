package squeal.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import squeal.Setup;

public class Bottom extends JPanel {
	
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	
	public Bottom() {
		
		setPreferredSize(new Dimension(Setup.getWidth(), Setup.getHeight() / 4));
		
		start.addActionListener(new ButtonListener());
		help.addActionListener(new ButtonListener());
		
		add(help);
		add(start);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == start) {
				
				System.out.println("Account List: " + Setup.getMainPanel().getTopLeftPanel().getAccountsFile());
				System.out.println("Prize Log: " + Setup.getMainPanel().getTopLeftPanel().getPrizesFile());
				
				if(Setup.getMainPanel().getTopRightPanel().isGlobalPassEnabled()) {
					
					System.out.println("Global Password: " + Setup.getMainPanel().getTopRightPanel().getGlobalPassword());
					
				}
				
				Setup.dispose();
				
			}
			
			if(e.getSource() == help) {
				
				try {
					
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.powerbot.org/community/topic/755991-squeal-of-fortune-spinner/"));
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		}
		
	}

}
