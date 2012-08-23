package squeal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import squeal.Setup;


public class MainOptionsPanel extends JPanel {
	
	private TopRight topRightPanel = new TopRight();
	private TopLeft topLeftPanel = new TopLeft();

	public MainOptionsPanel() {
		
		setPreferredSize(new Dimension(Setup.getWidth(), Setup.getHeight()));
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		
		top.setPreferredSize(new Dimension(Setup.getWidth(), (int) (Setup.getHeight() * 0.75)));
		top.setLayout(new BorderLayout());
		
		top.add(topLeftPanel, BorderLayout.WEST);
		top.add(topRightPanel, BorderLayout.EAST);
		
		add(top, BorderLayout.NORTH);
		add(new Bottom(), BorderLayout.SOUTH);
		
	}
	
	public TopRight getTopRightPanel() {
		
		return topRightPanel;
		
	}
	
	public TopLeft getTopLeftPanel() {
		
		return topLeftPanel;
		
	}
	
	
}
