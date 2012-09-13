package squeal.gui;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.powerbot.game.api.methods.Environment;

import squeal.Setup;

public class TopLeft extends JPanel {
	
	private JTextField ids = new JTextField(10);
	private JTextField prizes = new JTextField(10);
	private JButton browse = new JButton("...");
	private JButton browse2 = new JButton("Open");
	private String location = Environment.getStorageDirectory() + "\\";
	
	public TopLeft() {
		
		setPreferredSize(new Dimension(Setup.getWidth() / 2, (int) (Setup.getHeight() * 0.75)));
		
		JPanel account = new JPanel();
		add(new JLabel("Id List:      "));
		
		account.add(ids);
		
		browse.addActionListener(new FileChoosing());
		
		account.add(browse);
		
		add(account);
		
		JPanel prize = new JPanel();
		add(new JLabel("Prize List Location: "));
		prize.add(prizes);

		prizes.setText(location);
		prizes.setEnabled(false);
		
		browse2.addActionListener(new FileChoosing());
		
		prize.add(browse2);
		
		add(prize);
		
	}
	
	public String getIdsFile() {
		
		return ids.getText();
		
	}
	
	public String getPrizesFile() {
		
		return prizes.getText();
		
	}
	
	private class FileChoosing implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == browse) {
				
				JFileChooser chooser = new JFileChooser();
			
				int approve = chooser.showOpenDialog(null);	
				
				
				if(approve == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = chooser.getSelectedFile();
					
					if(e.getSource() == browse) {
						
						ids.setText(selectedFile.getAbsolutePath());
						
					}
					
					if(e.getSource() == browse2) {
						
						try {
							
							Desktop.getDesktop().open(new File(location));
							
						} catch (IOException e1) {

							e1.printStackTrace();
							
						}
						
						//prizes.setText(selectedFile.getAbsolutePath());
						
					}
				
				
				}
				
			}
			
			if(e.getSource() == browse2) {
				
				try {
					
					Desktop.getDesktop().open(new File(location));
					
				} catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				
			}
			
			
			
			
		}
		
	}

}
