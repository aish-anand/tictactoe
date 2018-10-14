package controller;
import model.*;
import view.*;
import java.util.*;

public class Controller {
	private Model m;
	private View v;
	
	public void setModel(Model m) {
		this.m = m;
	}
	
	public void setRequest(ArrayList<Integer> pos) {
		m.play(pos.get(0), pos.get(1));
	}
	
	public void setRequest() {
		m.ResetModel();
	}
 }
