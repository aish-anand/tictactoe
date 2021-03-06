package model;

import view.View;

//this class keeps track of game board state and includes logic of the game.

public class Model {
	private View v;//will create a view next 
	private int playerId; //new ID for each player
	private int moves; //number of moves made
	private char[][] gameBoard; //state of the board as a matrix
	private String message; //display message

	// default constructor
	public Model() {
		this.gameBoard = new char[3][3];
		this.moves = 9;
		this.playerId = 1;
	}
	
	//basic setters and getters methods
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int movesCount) {
		this.moves = movesCount;
	}

	public char[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(char[][] board) {
		this.gameBoard = board;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//constructor to initialize the reference of view class
	public void registerView(View v) {
		this.v = v;
	}

	// update the game board model
	public void play(int x, int y) {
		if(getMoves() > 0){
			// mark the board with X or O
			if(playerId%2 != 0) 
				gameBoard[x][y] = 'X';
			else 
				gameBoard[x][y] = 'O';
			
			// decrement moves
			setMoves(--moves);
			
			// check if player has won or if game is tied and update view accordingly
			if(isWinner(x, y)) {
				setMessage("Player " + playerId + " is Winner!");
				v.isWinner(x, y, gameBoard[x][y], getMessage());
			}
			else if(getMoves()==0) {
				setMessage("The game ended in a tie :(");
				v.isWinner(x, y, gameBoard[x][y], getMessage());
			}
			else {
				if(playerId%2 != 0) {
					// toggle the playerId
					setPlayerId(2);
					setMessage("Next Move by Player " +getPlayerId() + " - O");
				}
				else {
					setPlayerId(1);
					setMessage("Next Move by Player " +getPlayerId() + " - X");

				}
				// update the board with message for next player
				v.update(x, y, gameBoard[x][y], getMessage());
			}
			
		}
		
	}
	
	// clear the model and reset it to initial state
		public void ResetModel() {
			moves = 9;
			setPlayerId(1);
			setMessage("");
			for(int i=0; i<gameBoard.length;i++) {
				for(int j=0; j<gameBoard.length;j++) {
					gameBoard[i][j] = '\0';
				}
			}
			v.resetGame();
			
		}
	
	// check if there is a winner
	public boolean isWinner(int x, int y) {
		int countRow = 0;
		int countCol = 0;
		int countLeftDiag = 0;
		int countRightDiag = 0;
		char markerSymbol;
		if(getPlayerId() %2 !=0)
			markerSymbol = 'X';
		else
			markerSymbol = 'O';
		
		for(int i=0; i<gameBoard.length;i++) {
			if(gameBoard[x][i] == markerSymbol)
				countRow++;
			if(gameBoard[i][y] == markerSymbol)
				countCol++;
			if(gameBoard[i][i] == markerSymbol)
				countRightDiag++;
			if(gameBoard[gameBoard.length-1-i][i] == markerSymbol)
				countLeftDiag++;	
		}
		
		if(countCol==gameBoard.length || countRow==gameBoard.length 
		   || countLeftDiag == gameBoard.length || countRightDiag == gameBoard.length)
			return true;
		
		return false;
	}
		
}