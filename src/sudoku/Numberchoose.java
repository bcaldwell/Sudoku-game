package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Numberchoose extends JPanel implements MouseListener{
	
	
	
	
	public void paintComponent (Graphics g){
		if (g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paintComponent(g);
		
		//draw boxes
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 50, 75);
		g.fillRect(70, 10, 50, 75);
		g.fillRect(130, 10, 50, 75);
		g.fillRect(190, 10, 50, 75);
		g.fillRect(250, 10, 50, 75);

		g.fillRect(10, 90, 50, 75);
		g.fillRect(70, 90, 50, 75);
		g.fillRect(130, 90, 50, 75);
		g.fillRect(190, 90, 50, 75);
		g.fillRect(250, 90, 50, 75);
		
		g.setColor(Color.RED);
		setFont(new Font ("Arial", Font.PLAIN, 50));
		g.drawString("1", 22, 70);
		g.drawString("2", 82, 70);
		g.drawString("3", 142, 70);
		g.drawString("4", 202, 70);
		g.drawString("5", 262, 70);
		
		g.drawString("6", 22, 150);
		g.drawString("7", 82, 150);
		g.drawString("8", 142, 150);
		g.drawString("9", 202, 150);
		g.drawString("X", 262, 150);
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		
		
		Main.current[Main.sudy][Main.sudx]=functions.numberselected(event.getX(), event.getY());
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
