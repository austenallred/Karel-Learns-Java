/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run(){
		while (frontIsClear()){
			checkColumn();
			moveColumns();
		}
		//Now on the last column, but still need to check it.
		checkColumn();
	}
	
private void checkColumn(){
	//This method makes sure Karel fills up the entire column with beepers
	turnLeft();
	while (frontIsClear()) {
		setBeeper();
		move();
	}
	//On the last corner, need to set the last beeper
	setBeeper();	
}

private void setBeeper(){
	//A simple check to make sure we're not putting two beepers on one spot - there's not much of a reason to ever use putBeeper alone without this check first
	if (noBeepersPresent()) {
		putBeeper();
	}
}

private void moveColumns(){
	//This gets Karel from where he's at to the bottom of the next column, and gets him facing forward (since the first check is to see if frontIsClear();
	turnRight();
	move();
	move();
	move();
	move();
	turnRight();
	move();
	move();
	move();
	move();
	turnLeft();
}
}
