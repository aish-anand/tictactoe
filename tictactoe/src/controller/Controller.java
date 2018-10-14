package controller;
import model.*;
import java.util.*;

//controller class requests the model to update the state,
//on click of a button on the game board

public class Controller {
	private Model m;
	
	// set the reference of model class
	public void setModel(Model m) {
		this.m = m;
	}
	
	//request the model object to update game board
	public void setRequest(ArrayList<Integer> pos) {
		m.play(pos.get(0), pos.get(1));
	}
	
	//reset the board (overloaded method)
	public void setRequest() {
		m.ResetModel();
	}
 }
