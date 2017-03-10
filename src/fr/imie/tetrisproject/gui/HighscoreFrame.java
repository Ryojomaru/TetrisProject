package fr.imie.tetrisproject.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HighscoreFrame extends JFrame{

	public HighscoreFrame(){
		
		setSize(400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tetris - Highscores");
		
		JPanel highscores = new JPanel(new BorderLayout());
		
		JButton returnToHighscores = new JButton("Return to Menu");
		returnToHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuFrame returnToMenu = new MenuFrame();
			}
		});

		highscores.add(returnToHighscores,BorderLayout.SOUTH);
		
		setContentPane(highscores);
		setVisible(true);
		
	}
	
}
