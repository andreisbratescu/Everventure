package package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UI{
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healthBarPanel, loginPanel, registerPanel,loginButtonPanel,
			loginButtonPanel1,loginMessagePanel, registerMessagePanel, imagePanel, savequitPanel;
	JLabel titleNameLabel, weaponLabel,weaponNameLabel, imageLabel;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	JProgressBar healthBar;
	ImageIcon image;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90 );
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26 );
	String text;
	int i;
	MouseHandler mHandler = new MouseHandler();
	public void createUI(Game.ChoiceHandler cHandler) {

		// Window

		window = new JFrame();
		window.setSize(1024, 768);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.addMouseListener(mHandler);

		// Title Screen

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(128, 128, 768, 640);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("EVERVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(384, 512, 256, 128);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);

		window.add(titleNamePanel);
		window.add(startButtonPanel);
		//Game screen

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(64,448,550,320);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);

		mainTextArea = new JTextArea("Here we have the main text area");
		mainTextArea.setBounds(64,448,550,320);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(640,448,320,192);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);

		choice1 = new JButton("choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton("choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);



		playerPanel = new JPanel();
		playerPanel.setBounds(640,128,345,128);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2,1));
		window.add(playerPanel);

		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(640,80,256,38);
		healthBarPanel.setBackground(Color.black);
		window.add(healthBarPanel);

		healthBar = new JProgressBar(0,15);
		healthBar.setPreferredSize(new Dimension(256,384));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.green);
		healthBarPanel.add(healthBar);

		imagePanel = new JPanel();
		imagePanel.setBounds(64,64,512,308);
		imagePanel.setBackground(Color.black);

		imageLabel = new JLabel();
		image = new ImageIcon();
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);

		window.add(imagePanel);

		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponNameLabel = new JLabel();
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setForeground(Color.white);
		playerPanel.add(weaponNameLabel);

		window.setVisible(true);
	}
	Timer timer = new Timer(40, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			char character[] = text.toCharArray();
			int arrayNumber = character.length;

			String addedCharacter = "";
			String blank = "";

			addedCharacter = blank + character[i];
			mainTextArea.append(addedCharacter);

			i++;

			if( i == arrayNumber)
			{
				i = 0;
				timer.stop();
				choiceButtonPanel.setVisible(true);
			}

		}
	});
	 public void prepareText(){

		 i = 0;
		 mainTextArea.setText("");
		 timer.start();
	 }


	public class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}
		@Override
		public void mousePressed(MouseEvent e)
		{
			timer.stop();
			mainTextArea.setText(text);
			i = 0;
			choiceButtonPanel.setVisible(true);
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{

		}
		@Override
		public void mouseEntered(MouseEvent e)
		{

		}
		@Override
		public void mouseExited(MouseEvent e)
		{

		}


	}
}

