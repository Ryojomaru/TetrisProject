package fr.imie.tetrisproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{

	public MenuFrame(){
		
		setSize(400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tetris");
		
		JPanel menu = new JPanel(new BorderLayout());
		
		JPanel menuLogo = new JPanel();
		JPanel menuSelection = new JPanel(new GridBagLayout());
		GridBagConstraints menuConstraints = new GridBagConstraints();
		JPanel menuCredits = new JPanel(new FlowLayout());
		
		JButton menuPlay = new JButton("Play");
		menuPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JButton menuHighscores = new JButton("Highscores");
		menuHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HighscoresFrame highscores = new HighscoresFrame();
			}
		});
		
		JButton menuQuit = new JButton("Quit");
		menuQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		menuLogo.add(new JLabel("Voilà un logo"));
		
		
		menuConstraints.insets = new Insets(15, 0, 15, 0);
		menuConstraints.gridwidth = GridBagConstraints.REMAINDER;
		menuConstraints.fill = GridBagConstraints.HORIZONTAL;
		menuSelection.add(menuPlay,menuConstraints);
		menuSelection.add(menuHighscores,menuConstraints);
		menuSelection.add(menuQuit,menuConstraints);
		
		menuCredits.add(new JLabel("Copyright Max Squared Industries 2017"));
		
		menu.add(menuLogo,BorderLayout.NORTH);
		menu.add(menuSelection,BorderLayout.CENTER);
		menu.add(menuCredits,BorderLayout.SOUTH);
		
		setContentPane(menu);
		setVisible(true);
		
	}
	
}
