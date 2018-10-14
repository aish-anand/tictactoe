package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import adapter.*;

//this class is responsible to setup the GUI and handle view state changes

 public class View {
	private Adapter a;
	private JFrame gui;
    private JButton[][] blocks;
    private JButton reset;
    private JTextArea playerturn;
 
    //constructor
    public View() {
    		this.gui = new JFrame("Tic Tac Toe");
    		this.blocks = new JButton[3][3];
    		this.reset = new JButton("Reset");
    		this.playerturn = new JTextArea();   
    		initialize();
    }
    
    //listener for each button
    public void setActionListener(Controller c) {
		this.a = new Adapter(c, this);
		for(int row = 0; row < 3 ; row++) {
	        for(int col = 0; col < 3 ; col++) {
	        		blocks[row][col].addActionListener(a);
	        }
		}
	    reset.addActionListener(a);
    }
    
    //initialize layout
    public void initialize () {
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
	    
	    for(int row = 0; row < 3 ; row++) {
            for(int col = 0; col < 3 ; col++) {
                blocks[row][col] = new JButton();
                blocks[row][col].setPreferredSize(new Dimension(75,75));
                blocks[row][col].setText("");
                game.add(blocks[row][col]);
            }
	    }
	    gui.setVisible(true);
	}
    
    //update view with message
    public void update(int row, int column, char symbol, String message) {
 		blocks[row][column].setText(Character.toString(symbol));
 		blocks[row][column].setEnabled(false);
 		playerturn.setText(message);
 	
    }   
    
    //check for action event of the reset button
    public boolean isReset(ActionEvent e) {
		if(e.getSource() == reset)
			return true;
		return false;
    }

    //get (x,y) coordinates of the button pressed
    public ArrayList<Integer> getPosition(ActionEvent e) {
		ArrayList<Integer> position = new ArrayList<Integer>();
		for(int row = 0; row < 3 ; row++) {
	        for(int col = 0; col < 3 ; col++) {
	        		if(e.getSource() == blocks[row][col]) {
	        			position.add(row);
	        			position.add(col);
	        		}
	        }
		}
		return position;
    }
    
    //get value of button
    public String getButtonText(int i, int j) {
    	return blocks[i][j].getText();
    }
    
    
    //clear the view for a new game
    public void resetGame() {
    	for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                blocks[row][col].setText("");
                blocks[row][col].setEnabled(true);
            }
        }
    	playerturn.setText("Player 1 to play 'X'");
    }
   
    //when has ended, display message and don't allow further changes
    public void isWinner(int row, int column, char symbol, String message) {
 		blocks[row][column].setText(Character.toString(symbol));
 		blocks[row][column].setEnabled(false);
 		for(int i = 0; i < 3 ; i++) {
 	        for(int j = 0; j < 3 ; j++) {
 	        	blocks[i][j].setEnabled(false);
 	        }
 		}
 		playerturn.setText(message);
     }
}