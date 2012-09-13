package squeal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import squeal.Setup;
import squeal.Squeal;

public class Bottom extends JPanel {
	
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	
	private JCheckBox coins = new JCheckBox("Convert all to coins");
	private JCheckBox saveMask = new JCheckBox("Don't convert Fish Masks");
	
	public Bottom() {
		
		setPreferredSize(new Dimension(Setup.getWidth(), Setup.getHeight() / 4));
		
		setLayout(new BorderLayout());
		
		start.addActionListener(new ButtonListener());
		help.addActionListener(new ButtonListener());
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		
		saveMask.setEnabled(false);
		
		coins.addItemListener(new OptionsListener());
		saveMask.addItemListener(new OptionsListener());
		
		left.add(coins);
		left.add(saveMask);
		
		
		right.add(help);
		right.add(start);
		
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.WEST);
		
	}
	
	private class OptionsListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getSource() == coins) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					saveMask.setEnabled(true);
					
					Squeal.convertToCoins(true);
					
				} else {
					
					saveMask.setEnabled(false);
					
					Squeal.convertToCoins(false);
					
				}
				
			}
			
			if(e.getSource() == saveMask) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					Squeal.saveFishMasks(true);
					
				} else {
					
					Squeal.saveFishMasks(false);
					
				}
				
			}
			
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == start) {
				
				System.out.println("id List: " + Setup.getMainPanel().getTopLeftPanel().getIdsFile());
				System.out.println("Prize Log: " + Setup.getMainPanel().getTopLeftPanel().getPrizesFile());
				
				if(Setup.getMainPanel().getTopRightPanel().isGlobalSerEnabled()) {
					
					System.out.println("Global serial: " + Setup.getMainPanel().getTopRightPanel().getGlobalSer());
					
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
