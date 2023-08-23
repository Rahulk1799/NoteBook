package NoteBook;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {

	public About() {
	  setVisible(true);
	  setBounds(400,300,500,400);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setTitle("About NoteBook Application");
	  ImageIcon icon=new ImageIcon(getClass().getResource("notes.png"));
	  setIconImage(icon.getImage());
	  setLayout(null);
	  
	  JLabel iconlabel=new JLabel(new ImageIcon(getClass().getResource("notes.png")));
	  iconlabel.setBounds(180, 50, 100, 100);
	  add(iconlabel);
	  
	  JLabel j=new JLabel("<html>Welcome to the NoteBook !<br> This is a simple Text Editor which enables"
	  		+ " Computer users<br> to create the documents and save them.<br>All rights reserved to the<br> @NoteBook1999 <html>");
	  j.setBounds(100,160,400,200);
	  add(j);
	  Font f2=new Font("Times New Roman",Font.BOLD,20);
	  j.setFont(f2);
	}
}
