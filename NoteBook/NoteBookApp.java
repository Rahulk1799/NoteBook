package NoteBook;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NoteBookApp extends JFrame implements ActionListener {
	JTextArea textarea;
	public NoteBookApp() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NoteBook Application");
		setBounds(100,100,1033,518);
		
		//Adding Icons to the Frame.
		ImageIcon icon=new ImageIcon(getClass().getResource("notes.png"));
		setIconImage(icon.getImage());
		
		//Creating MenuBar
		
		JMenuBar menubar=new JMenuBar();
		JMenu file=new JMenu("File");
		JMenu edit=new JMenu("Edit");
		JMenu format=new JMenu("Format");
		JMenu help=new JMenu("Help");
		
		//Adding menu to the menuBar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		menubar.add(help);
		
		
		//Adding menuBar to the frame
		add(menubar);
		
		//Setting the menuBar
		setJMenuBar(menubar);
		menubar.setVisible(true);
		
		//Creating menu items
		JMenuItem newfile =new JMenuItem("New");
		JMenuItem openfile =new JMenuItem("Open");
		JMenuItem savefile =new JMenuItem("Save");
		JMenuItem print =new JMenuItem("Print");
		JMenuItem exit =new JMenuItem("Exit");
		
		//Adding menu items to the File menu
		file.add(newfile);
		file.add(openfile);
		file.add(savefile);
		file.add(print);
		file.add(exit);
		
		//Creating menu items
		JMenuItem cut =new JMenuItem("Cut");
		JMenuItem copy =new JMenuItem("Copy");
		JMenuItem paste =new JMenuItem("Paste");
		JMenuItem selectall =new JMenuItem("SelectAll");
		JMenuItem font=new JMenuItem("Font");
		JMenuItem viewhelp =new JMenuItem("View Help");
		JMenuItem sendfeedback =new JMenuItem("Send Feedback");
		JMenuItem aboutnotebook=new JMenuItem("About Notebook");
		
		//Adding menu items to the Edit menu
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		
		//Adding menu items to the Help menu
		help.add(viewhelp);
		help.add(sendfeedback);
		help.add(aboutnotebook);
		
		//Adding menu items to the Format menu
		format.add(font);
		
		//Creating TextArea to write the Document
		 textarea =new JTextArea();
		
		//Creating the ScrollPane and adding the textArea to it. 
		JScrollPane scrollpane =new JScrollPane(textarea);
		add(scrollpane);
		
		//Setting the Vertical and Horizontal Bars.
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		
		
		//Setting the Font and LineWrap and WordWrap of the TextArea
		textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		
		//Adding the ActionListener to the Menu
		newfile.addActionListener(this);
		openfile.addActionListener(this);
		savefile.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		
		aboutnotebook.addActionListener(this);
		
		newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
		
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));			
	}
	
	 //Implementing the ActionListener actionPerformed() method.
	 public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("New"))
		{
			textarea.setText(null);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Open"))
		{
			JFileChooser filechooser =new JFileChooser();
			FileNameExtensionFilter textfilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textfilter);
			
			int action=filechooser.showOpenDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
	
				try {
					BufferedReader reader=new BufferedReader(new FileReader(filechooser.getSelectedFile()));
					textarea.read(reader,null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	  else if(e.getActionCommand().equalsIgnoreCase("Save"))
		{
			JFileChooser filechooser =new JFileChooser();
			FileNameExtensionFilter textfilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textfilter);
			
			int action=filechooser.showSaveDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			else
			{
				String filename=filechooser.getSelectedFile().getAbsolutePath().toString();
				if(!(filename.contains(".txt")))
				{
					filename=filename+".txt";
				}
				
				try {
					BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
					textarea.write(writer);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Print"))
		{
			try {
				textarea.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Exit"))
		{
			System.exit(0);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Cut"))
		{
			textarea.cut();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Copy"))
		{
			textarea.copy();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Paste"))
		{
			textarea.paste();
		}
		else if(e.getActionCommand().equalsIgnoreCase("SelectAll"))
		{
			textarea.selectAll();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Font"))
		{
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("About Notebook"))
		{
			new About();
		}
		
	}

	public static void main(String[] args) throws Exception {
		NoteBookApp nb=new NoteBookApp();
		//Setting the Look and feel
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
}
