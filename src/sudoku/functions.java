package sudoku;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.prefs.Preferences;

public class functions {

	public static void loadpuzzle(int in) {
		Main.puzzle=String.format("Puzzle %01d", in);
		//String file = String.format("Puzzle_%01d.txt", in);
		
		Main.orig=levels.levelarray(in);
		Main.current=levels.levelarray(in);
		Main.answers=levels.levelanswers(in);
		//System.out.println(file);
		/*try (Scanner load = new Scanner(new File(file))) {

			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					Main.orig[a][b] = load.nextInt();
					Main.current[a][b] = Main.orig[a][b];
				}
			}

			// get answers
			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					Main.answers[a][b] = load.nextInt();

				}
			}

		} catch (FileNotFoundException e) {
			error("Error loading level");
		}*/

	}

	public static void loadsave() {

		try (Scanner load = new Scanner(new File("save.txt"))) {
			if (load.hasNextInt()) {

				for (int a = 0; a < 9; a++) {
					for (int b = 0; b < 9; b++) {
						Main.orig[a][b] = load.nextInt();
					}
				}

				for (int a = 0; a < 9; a++) {
					for (int b = 0; b < 9; b++) {
						Main.current[a][b] = load.nextInt();
					}
				}

				for (int a = 0; a < 9; a++) {
					for (int b = 0; b < 9; b++) {
						Main.answers[a][b] = load.nextInt();
					}
				}
				
				Main.puzzle=String.format("Puzzle %01d",load.nextInt());

			} else {
				loadpuzzle(1);

			}
		} catch (FileNotFoundException e) {
			loadpuzzle(1);

		}

	}

	public static void savegame() {
		
		File file = new File("save.txt");
		//Files.setAttribute(file, "dos:hidden", true);
		String current = "";

		try (BufferedWriter save = new BufferedWriter(new FileWriter(file))) {

			// save orignal puzzle
			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					current = String
							.format("%s %01d", current, Main.orig[a][b]);

				}

				save.write(current);
				save.newLine();
				current = "";
			}

			save.newLine();

			// save current puzzle

			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					current = String.format("%s %01d", current,
							Main.current[a][b]);

				}

				save.write(current);
				save.newLine();
				current = "";
			}
			// write anwers
			save.newLine();

			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					current = String.format("%s %01d", current,
							Main.answers[a][b]);

				}

				save.write(current);
				save.newLine();
				current = "";
			}
			
			save.newLine();
			save.write(Main.puzzle.substring(7,Main.puzzle.length()));

		} catch (IOException e) {
			error("Unable to save file");
		}
		// System.out.println("SAVED");*/
	}

	public static void runnumberchooser() {

		JFrame t = new JFrame("Number Chooser");
		t.add(new Numberchoose());
		t.addMouseListener(new Numberchoose());
		t.setSize(310, 210);
		t.setVisible(true);

	}

	public static int numberselected(int x, int y) {

		int box = 10;

		if (x > 625 & x < 675) {
			if (y > 105 & y < 155) {
				box = 1;
			} else if (y > 165 & y < 215) {
				box = 2;
			} else if (y > 225 & y < 275) {
				box = 3;
			} else if (y > 285 & y < 335) {
				box = 4;
			} else if (y > 345 & y < 395) {
				box = 5;
			} else if (y > 405 & y < 455) {
				box = 6;
			} else if (y > 465 & y < 515) {
				box = 7;
			} else if (y > 525 & y < 575) {
				box = 8;
			} else if (y > 585 & y < 635) {
				box = 9;
			} else if (y > 645 & y < 695) {
				box = 99;
			}
		}

		if (box != 10) {
			return box;
		}
		return 12;

	}

	public static boolean empty(int x, int y) {

		int boxx = 10;
		int boxy = 10;
		
		int a=5;
		int b=-5;

		if (x > 70+a & x < 120+a) {
			boxx = 0;
			Main.boxcord[0] = 70;
		} else if (x > 125+a & x < 175+a) {
			boxx = 1;
			Main.boxcord[0] = 125;
		} else if (x > 180+a & x < 230+a) {
			boxx = 2;
			Main.boxcord[0] = 180;
		} else if (x > 240+a & x < 290+a) {
			boxx = 3;
			Main.boxcord[0] = 240;
		} else if (x > 295+a & x < 345+a) {
			boxx = 4;
			Main.boxcord[0] = 295;
		} else if (x > 350+a & x < 400+a) {
			boxx = 5;
			Main.boxcord[0] = 350;
		} else if (x > 410+a & x < 460+a) {
			boxx = 6;
			Main.boxcord[0] = 410;
		} else if (x > 465+a & x < 515+a) {
			boxx = 7;
			Main.boxcord[0] = 465;
		} else if (x > 520+a & x < 570+a) {
			boxx = 8;
			Main.boxcord[0] = 520;
		}
		
		

		if (y > 125+b & y < 175+b) {
			boxy = 0;
			Main.boxcord[1] = 70;
		} else if (y > 180+b & y < 230+b) {
			boxy = 1;
			Main.boxcord[1] = 125;
		} else if (y > 235+b & y < 285+b) {
			boxy = 2;
			Main.boxcord[1] = 180;
		} else if (y > 295+b & y < 345+b) {
			boxy = 3;
			Main.boxcord[1] = 240;
		} else if (y > 350+b & y < 400+b) {
			boxy = 4;
			Main.boxcord[1] = 295;
		} else if (y > 405+b & y < 455+b) {
			boxy = 5;
			Main.boxcord[1] = 350;
		} else if (y > 465+b & y < 515+b) {
			boxy = 6;
			Main.boxcord[1] = 410;
		} else if (y > 520+b & y < 570+b) {
			boxy = 7;
			Main.boxcord[1] = 465;
		} else if (y > 575+b & y < 625+b) {
			boxy = 8;
			Main.boxcord[1] = 520;
		}

		if (boxy == 10 | boxx == 10) {
			return false;
		} else if (Main.orig[boxy][boxx] > 10) {
			Main.sudx = boxx;
			Main.sudy = boxy;
			return true;
		} else {
			Main.sudx = boxx;
			Main.sudy = boxy;
			//System.out.println(Main.orig[boxy][boxx]);
			return false;
		}

	}

	public static int getuserinput(String in) {
		String a = JOptionPane.showInputDialog("Please input a value");

		return Integer.parseInt(a);

	}

	public static void error(String in) {

		final JPanel panel = new JPanel();
		JOptionPane.showMessageDialog(panel, "Could not open file", "Error",
				JOptionPane.ERROR_MESSAGE);

	}

	public static void exit() {
		// Custom button text
		final JPanel frame = new JPanel();
		Object[] options = { "Save and Exit", "Exit" };
		int n = JOptionPane.showOptionDialog(frame,
				"Would you like to save your progess", "Save?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
		if (n == 0) {
			savegame();
		}

		System.exit(0);
	}

	public static void message(String in, String title) {
		final JPanel frame = new JPanel();
		JOptionPane.showMessageDialog(frame, title, in, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void check() {
		boolean right = true;

		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				if (Main.answers[a][b] != Main.current[a][b]) {
					right = false;
				}
			}
		}
		System.out.println(right);
		
		if (right){
			message("Congrates!","You have successfully completed the puzzle");
		}else{
			message("Opps","It is not quiet right");
		}

	}
}
