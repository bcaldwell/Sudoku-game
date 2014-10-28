package sudoku;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GUI extends JPanel implements MouseListener{
	
	
	
	
	public void paintComponent (Graphics g){
		if (g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paintComponent(g);

		//this.setBackground(Color.RED);
		
		g.setColor(Color.BLACK);
		//draw vertical lines
		g.fillRect(50, 50, 20, 540);
		g.fillRect(120, 50, 5, 540);
		g.fillRect(175, 50, 5, 540);
		g.fillRect(230, 50, 10, 540);
		g.fillRect(290, 50, 5, 540);
		g.fillRect(345, 50, 5, 540);
		g.fillRect(400, 50, 10, 540);
		g.fillRect(460, 50, 5, 540);
		g.fillRect(515, 50, 5, 540);
		g.fillRect(570, 50, 20, 540);
		
		//draw horizontal lines
		g.fillRect(50, 50, 540, 20);
		g.fillRect(50, 120, 540, 05);
		g.fillRect(50, 175, 540, 05);
		g.fillRect(50, 230, 540, 10);
		g.fillRect(50, 290, 540, 05);
		g.fillRect(50, 345, 540, 05);
		g.fillRect(50, 400, 540, 10);
		g.fillRect(50, 460, 540, 05);
		g.fillRect(50, 515, 540, 05);
		g.fillRect(50, 570, 540, 20);
		//g.setColor(new Color(190,81,215));
		//g.fillRect(100, 100, 30, 40);
		setFont(new Font ("Arial", Font.PLAIN, 50));
		g.drawString (Main.puzzle,50,45);
		
		
		if (Main.boxsected){
			g.setColor(Color.BLUE);
			g.fillRect(Main.boxcord[0],Main.boxcord[1],50,50);
		}
		
	
		
		int[] xnumval = new int [] {80,135,190,250,305,360,420,475,530}; 
		int[] ynumval = new int [] {115,170,225,285,340,395,455,510,565}; 
		
		g.setColor(Color.RED);
		setFont(new Font ("Arial", Font.PLAIN, 50));
		
		
		for (int x=0; x<9;x++){
			for (int y=0; y<9;y++){
				if (Main.current[y][x]<10){
			g.drawString(new Integer(Main.current[y][x]).toString(), xnumval[x], ynumval[y]);
				}
			}
		}
		
		//Draw numbers
		g.setColor(Color.BLACK);
		g.fillRect(625, 50, 50, 50);
		g.fillRect(625, 110, 50, 50);
		g.fillRect(625, 170, 50, 50);
		g.fillRect(625, 230, 50, 50);
		g.fillRect(625, 290, 50, 50);

		g.fillRect(625, 350, 50, 50);
		g.fillRect(625, 410, 50, 50);
		g.fillRect(625, 470, 50, 50);
		g.fillRect(625, 530, 50, 50);
		g.fillRect(625, 590, 50, 50);
		
		g.setColor(Color.RED);
		setFont(new Font ("Arial", Font.PLAIN, 50));
		g.drawString("1", 635, 95);
		g.drawString("2", 635, 155);
		g.drawString("3", 635, 215);
		g.drawString("4", 635, 275);
		g.drawString("5", 635, 335);
		
		g.drawString("6", 635, 395);
		g.drawString("7", 635, 455);
		g.drawString("8", 635, 515);
		g.drawString("9", 635, 575);
		g.drawString("X", 635, 635);
		
		
		
		
		}
		
	
	public void mouseClicked(MouseEvent event){
		Main.mousex=event.getX();
		Main.mousey=event.getY();
		Main.mouseclick=true;
		boolean a=functions.empty(Main.mousex,Main.mousey);
		
		System.out.println(Main.sudx+" "+Main.sudy+" "+a);
		System.out.println(functions.numberselected(event.getX(), event.getY()));
		System.out.println(Main.mousex+" "+Main.mousey);
		
		
			//functions.runnumberchooser();
			if (a){
				Main.boxsected=true;
			}else if (a==false){
				//Main.boxcord[0]=5000;
				//Main.boxcord[1]=5000;
				Main.boxsected=false;
				
			}
			
		if (functions.numberselected(Main.mousex, Main.mousey)!=12){
			System.out.println(functions.numberselected(Main.mousex, Main.mousey));
			Main.current[Main.sudy][Main.sudx]=functions.numberselected(event.getX(), event.getY());

		}
		
		
	}
	public void mousePressed (MouseEvent event){}	
	public void mouseReleased (MouseEvent event){}
	public void mouseEntered(MouseEvent event){
		//System.out.println("Entered");
	}
	public void mouseExited (MouseEvent event){}
	
}

/*
private JTextField item1;
private JTextField item2;
private JTextField item3;
private JPasswordField itempass;



public GUI(){
	super ("Sudoku");
	setLayout (new FlowLayout());
	
	item1=new JTextField(10);
	add (item1);
	
	item2=new JTextField("Enter text here",15);
	add (item2);
	
	item3=new JTextField("uneditbale",20);
	item3.setEditable(false);
	add (item3);
	
	itempass = new JPasswordField ("mypass");
	add (itempass);
	
	
	thehandler handler = new thehandler();
	item1.addActionListener(handler);
	item2.addActionListener(handler);
	item3.addActionListener(handler);
	itempass.addActionListener (handler);
	
	
}

private class thehandler implements ActionListener {
	
	public void actionPerformed (ActionEvent event){
		
		String string = "";
		
		if (event.getSource()==item1){
			string=String.format("field 1: %s", event.getActionCommand());
		} else if (event.getSource()==item2){
			string=String.format("field 2: %s", event.getActionCommand());
		} else if (event.getSource()==item3){
			string=String.format("field 3: %s", event.getActionCommand());
		}else if (event.getSource()==itempass){
			string=String.format("password is: %s", event.getActionCommand());
		}
		
		JOptionPane.showMessageDialog(null,string);
		
	}
	
}
*/
