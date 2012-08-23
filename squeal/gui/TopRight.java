package squeal.gui;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import squeal.Setup;

public class TopRight extends JPanel {
	
	private JTextField globalPass = new JTextField(10);
	private JRadioButton yes = new JRadioButton("Yes");
	private JRadioButton no = new JRadioButton("No");
	private JPanel globalPanel = new JPanel();
	
	public TopRight() {
		
		setPreferredSize(new Dimension(Setup.getWidth() / 2, (int) (Setup.getHeight() * 0.75)));
		
		add(new JLabel("Use global password?"));
		
		JPanel choice = new JPanel();
		
		ButtonGroup choices = new ButtonGroup();
		
		yes.addItemListener(new YesOrNo());
		no.addItemListener(new YesOrNo());
		
		choices.add(yes);
		choices.add(no);
		
		choice.add(yes);
		choice.add(no);
		
		no.setSelected(true);
		
		add(choice);
		
		globalPanel.setPreferredSize(new Dimension(Setup.getWidth() / 2, 100));
		
		globalPanel.add(new JLabel("Global password:"));
		
		globalPanel.add(globalPass);
		
		add(globalPanel);
		
		
	}
	
	public boolean isGlobalPassEnabled() {
		
		return globalPass.isEnabled();
		
	}
	
	public String getGlobalPassword() {
		
		return globalPass.getText();
		
	}
	
	private class YesOrNo implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			
			if(event.getSource() == yes) {
				
				globalPanel.setVisible(true);
				globalPass.setEnabled(true);
				
			} else {
				
				globalPanel.setVisible(false);
				globalPass.setEnabled(false);
				
			}
			
		}
		
	}

}
