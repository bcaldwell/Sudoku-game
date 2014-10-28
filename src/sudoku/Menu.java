package sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Menu extends JFrame {

    public Menu() {
        initUI();
    }

    public final void initUI() {

        JMenuBar menubar = new JMenuBar();
        //ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit application");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	functions.exit();
            }
        });
        
        JMenuItem check = new JMenuItem("Check Puzzle");
        check.setMnemonic(KeyEvent.VK_E);
        check.setToolTipText("Check Puzzle");
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	functions.check();
            }
        });
        
        JMenuItem save = new JMenuItem("Save");
        save.setMnemonic(KeyEvent.VK_E);
        save.setToolTipText("Save Current Game");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                functions.savegame();
            	
            }
        });
        
        JMenu Puzzle = new JMenu("Select Puzzle");
        Puzzle.setMnemonic(KeyEvent.VK_M);

        JMenuItem P1 = new JMenuItem("Puzzle 1");
        P1.setMnemonic(KeyEvent.VK_E);
        P1.setToolTipText("Open Puzzle 1");
        P1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                functions.loadpuzzle(1);
            	
            }
        });
        
        JMenuItem P2 = new JMenuItem("Puzzle 2");
        P2.setMnemonic(KeyEvent.VK_E);
        P2.setToolTipText("Open Puzzle 2");
        P2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                functions.loadpuzzle(2);
            	
            }
        });
        
        JMenuItem P3 = new JMenuItem("Puzzle 3");
        P3.setMnemonic(KeyEvent.VK_E);
        P3.setToolTipText("Open Puzzle 3");
        P3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                functions.loadpuzzle(3);
            	
            }
        });
        
        JMenuItem P4 = new JMenuItem("Puzzle 4");
        P4.setMnemonic(KeyEvent.VK_E);
        P4.setToolTipText("Open Puzzle 4");
        P4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                functions.loadpuzzle(4);
            	
            }
        });
        
        

        Puzzle.add(P1);
        Puzzle.add(P2);
        Puzzle.add(P3);
        Puzzle.add(P4);
        
       
        file.add(save);
        file.add(Puzzle);
        file.add(check);
        file.addSeparator();
        file.add(exit);
       

        menubar.add(file);

        setJMenuBar(menubar);

       setTitle("Sudoku");
       setSize(725, 700);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

   
}