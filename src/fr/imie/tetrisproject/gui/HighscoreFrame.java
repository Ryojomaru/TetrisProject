package fr.imie.tetrisproject.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.imie.tetrisproject.tetris.highscore.*;

public class HighscoreFrame extends JFrame{

	public HighscoreFrame(){
		
		setSize(400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tetris - Highscores");
		
		JPanel highscores = new JPanel(new BorderLayout());
		
		Object[] scores = HighscoreDisplay.HighscoreDisplay();
		
		JLabel score1 = new JLabel("1er : " + scores[0]);
		JLabel score2 = new JLabel("2ème : " + scores[1]);
		JLabel score3 = new JLabel("3ème : " + scores[2]);
		JLabel score4 = new JLabel("4ème : " + scores[3]);
		JLabel score5 = new JLabel("5ème : " + scores[4]);
		
		JButton returnToHighscores = new JButton("Return to Menu");
		returnToHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuFrame returnToMenu = new MenuFrame();
			}
		});
		
		//Foutre dans un grid bag 
		highscores.add(score1,BorderLayout.NORTH);
		highscores.add(score2,BorderLayout.NORTH);
		highscores.add(score3,BorderLayout.NORTH);
		highscores.add(score4,BorderLayout.NORTH);
		highscores.add(score5,BorderLayout.NORTH);
		highscores.add(returnToHighscores,BorderLayout.SOUTH);
		
		setContentPane(highscores);
		setVisible(true);
		
	}
	
}
