package fr.imie.tetrisproject.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
		
		JPanel displayHighscores = new JPanel(new GridBagLayout());
		GridBagConstraints displayConstraints = new GridBagConstraints();
		
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
		
		displayConstraints.insets = new Insets(15, 0, 15, 0);
		displayConstraints.gridheight = 5; displayConstraints.gridwidth = 3; displayConstraints.gridx = 2;
		displayHighscores.add(score1,displayConstraints);
		displayHighscores.add(score2,displayConstraints);
		displayHighscores.add(score3,displayConstraints);
		displayHighscores.add(score4,displayConstraints);
		displayHighscores.add(score5,displayConstraints);
		
		highscores.add(displayHighscores, BorderLayout.NORTH);
		highscores.add(returnToHighscores,BorderLayout.SOUTH);
		
		setContentPane(highscores);
		setVisible(true);
		
	}
	
}
