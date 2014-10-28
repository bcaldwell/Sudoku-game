package sudoku;

import java.awt.*;

import javax.swing.*;

import java.awt.Event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse extends JFrame{

	private JPanel mousepanel;
	//private JLabel statusbar;
	
	public Mouse(){
		super("title");
		
		mousepanel=new JPanel();
		//mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		
		//statusbar=new JLabel("default");
		//add(statusbar, BorderLayout.SOUTH);
		
		Handlerclass handler = new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener (handler);
		
		
	}
	
	public class Handlerclass implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent event){
			Main.mousex=event.getX();
			Main.mousey=event.getY();
			Main.mouseclick=true;
		}
		public void mousePressed (MouseEvent event){
			//statusbar.setText("You pressed down the mouse");
		}
		
		public void mouseReleased (MouseEvent event){
			//statusbar.setText("You release the button");
		}
		public void mouseEntered(MouseEvent event){
			//statusbar.setText("You are in the pannel");
			//mousepanel.setBackground (Color.RED);
		}
		public void mouseExited (MouseEvent event){
			//statusbar.setText("You are not in the window");
			//mousepanel.setBackground (Color.WHITE);
		}
		public void mouseDragged(MouseEvent event) {
			//statusbar.setText("mouse being dragged");
			//mousepanel.setBackground (Color.BLUE);
			
		}
		public void mouseMoved(MouseEvent event) {
			//statusbar.setText("mouse being moved");
			
		}
	}
	
}
