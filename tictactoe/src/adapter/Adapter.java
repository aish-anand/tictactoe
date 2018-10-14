package adapter;
import controller.*;
import view.*;
import java.awt.event.*;
import java.util.*;

//this acts as an interface between view and controller
//and allows for decoupling; listens for actions and invokes controller

public class Adapter implements ActionListener {
	private Controller c;
    private View v;
	
    //initialize the references of controller and view 
    public Adapter(Controller c, View v) {
        this.c = c;
        this.v = v;
    }
	
    //invoke right methods based on action
    public void actionPerformed(ActionEvent e) {
        if(v.isReset(e))
        	c.setRequest();
        else {
        	ArrayList<Integer> position = v.getPosition(e);
        	c.setRequest(position);
        }
    }
}