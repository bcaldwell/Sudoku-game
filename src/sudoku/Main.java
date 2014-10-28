package sudoku;

import java.awt.MouseInfo;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import sudoku.Mouse.Handlerclass;

public class Main {
	
	public static int[][] current = new int[9][9];
	public static int[][] orig = new int[9][9];
	public static int[][] answers = new int[9][9];
	public static int mousex;
	public static int mousey;
	public static boolean mouseclick=false;
	public static int sudx;
	public static int sudy;
	public static int numberselected;
	public static boolean boxsected= false;
	public static int[] boxcord= new int[] {50,100};
	public static String puzzle="Puzzle";
	

	public static void main(String[] args) {
		
		
		functions.loadsave();
		
		Menu f = new Menu ();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new GUI());
		f.addMouseListener(new GUI());
		f.setSize(725,700);
		f.setVisible(true);
				
	}
	
	

}
