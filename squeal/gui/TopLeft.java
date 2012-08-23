package squeal.gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import squeal.Setup;

public class TopLeft extends JPanel {
	
	private JTextField accounts = new JTextField(10);
	private JTextField prizes = new JTextField(10);
	private JButton browse = new JButton("...");
	private JButton browse2 = new JButton("...");
	
	public TopLeft() {
		
		setPreferredSize(new Dimension(Setup.getWidth() / 2, (int) (Setup.getHeight() * 0.75)));
		
		JPanel account = new JPanel();
		
		add(new JLabel("Account List: "));
		
		account.add(accounts);
		
		browse.addActionListener(new FileChoosing());
		
		account.add(browse);
		
		add(account);
		
		JPanel prize = new JPanel();
		add(new JLabel("Prize List: "));
		prize.add(prizes);

		browse2.addActionListener(new FileChoosing());
		
		prize.add(browse2);
		
		add(prize);
		
	}
	
	public String getAccountsFile() {
		
		return accounts.getText();
		
	}
	
	public String getPrizesFile() {
		
		return prizes.getText();
		
	}
	
	private class FileChoosing implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser chooser = new JFileChooser();
			
			int approve = chooser.showOpenDialog(null);
			
			if(approve == JFileChooser.APPROVE_OPTION) {
			
				File selectedFile = chooser.getSelectedFile();
				
				if(e.getSource() == browse) {
					
					accounts.setText(selectedFile.getAbsolutePath());
					
				}
				
				if(e.getSource() == browse2) {
					
					prizes.setText(selectedFile.getAbsolutePath());
					
				}
			
			
			}
			
		}
		
	}

}
