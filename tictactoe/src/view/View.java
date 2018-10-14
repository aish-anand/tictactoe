package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import adapter.*;

//WIP View class

 public class View {
	private Controller c;
	private Adapter a;
	private JFrame gui;
    private JButton[][] blocks;
    private JButton reset;
    private JTextArea playerturn;
 
    public View() {
    		this.gui = new JFrame("Tic Tac Toe");
    		this.blocks = new JButton[3][3];
    		this.reset = new JButton("Reset");
    		this.playerturn = new JTextArea();   
    		this.c = new Controller();
    		this.a = new Adapter(c);
    		
    		initialize();
    		initButtons();
    }
    
    public void initialize () {
	    	gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.setSize(new Dimension(500, 350));
	    gui.setResizable(true);
	    
	    JPanel gamePanel = new JPanel(new FlowLayout());
	    JPanel game = new JPanel(new GridLayout(3,3));
	    gamePanel.add(game, BorderLayout.CENTER);
	    JPanel options = new JPanel(new FlowLayout());
	    options.add(reset);
	    JPanel messages = new JPanel(new FlowLayout());
	    messages.setBackground(Color.white);
	    gui.add(gamePanel, BorderLayout.NORTH);
	    gui.add(options, BorderLayout.CENTER);
	    gui.add(messages, BorderLayout.SOUTH);
	    messages.add(playerturn);
	    playerturn.setText("Player 1 to play 'X'");
	    
	    reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset(); //like in main tictactoe.java
            }
        });
	    
	    for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                	 public void actionPerformed(ActionEvent e) {
		            }
                });
            }
	    }
	}
    
	public void initButtons() {
	    for(int row = 0; row<3 ;row++) {
	        for(int column = 0; column<3 ;column++) {
	            blocks[row][column] = new JButton();
	            blocks[row][column].setPreferredSize(new Dimension(75,75));
	            blocks[row][column].setText("");
//	            game.add(blocks[row][column]); //needs to refer to the game board.
	            blocks[row][column].addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            		// will call adapter here
		            }
	         
		        });
		    }
		}
	}
	
    public void update() {
    	
    }
    
    public void reset() {
    	//like resetgame() in tictactoe.java
    }
    
    public void isWinner() {
    	//to display winner
    }
   
}