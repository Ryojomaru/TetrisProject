package fr.imie.tetrisproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Menu extends JFrame{

	public Menu(){
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tetris");
		
		JPanel menu = new JPanel(new BorderLayout());
		
		JPanel menuLogo = new JPanel();
		JPanel menuSelection = new JPanel(new GridBagLayout());
		GridBagConstraints menuConstraints = new GridBagConstraints();
		JPanel menuCredits = new JPanel(new FlowLayout());
		
		menuSelection.setBackground(Color.black);
		
		menuLogo.add(new JLabel("Voilà un logo"));
		
		menuConstraints.fill = GridBagConstraints.HORIZONTAL;
		menuConstraints.gridx = 1; menuConstraints.gridy = 0;
		menuSelection.add(new JButton("Play"),menuConstraints);
		menuConstraints.gridx = 1; menuConstraints.gridy = 1;
		menuSelection.add(new JButton("HighScore"),menuConstraints);
		menuConstraints.gridx = 1; menuConstraints.gridy = 2;
		menuSelection.add(new JButton("Quit"),menuConstraints);
		
		menuCredits.add(new JLabel("Copyright Max Squared Industries 2017"));
		
		menu.add(menuLogo,BorderLayout.NORTH);
		menu.add(menuSelection,BorderLayout.CENTER);
		menu.add(menuCredits,BorderLayout.SOUTH);
		
		setContentPane(menu);
		setVisible(true);
		
	}
	
}
