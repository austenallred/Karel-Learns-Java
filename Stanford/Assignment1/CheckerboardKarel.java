/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		//I like karel to start going up instead of sideways.
		//Personal preference, I suppose
		turnLeft();
		//Fills the first row
		fillRow();
		//Turns and fills until the checkerboard done
		turnAndFill();
	}	

private void fillRow(){
	//This method fills a single column. It starts with a move,
	//so if you want Karel to put a beeper down first, you have
	//to do so in another method
	while (frontIsClear()) {
		move();
		putBeeper();
		if (frontIsClear()) {
			move();
		}
	} 
	
}

private void turnAndFill(){
	//There are four possibilities of what Karel can do, based on
	//If there is a beeper present and which way Karel is facing.
	//for simplicity sake, those are broken up into four methods
	if (facingNorth() && beepersPresent()){
		facingNorthOnBlack();
	} else if (facingNorth() && noBeepersPresent()) {
		facingNorthOnWhite();
	} else if (facingSouth() && beepersPresent()){
		facingSouthOnBlack();
	} else if (facingSouth() && noBeepersPresent()){
		facingSouthOnWhite();
	}
	
}

private void facingNorthOnBlack(){
	if (rightIsClear()){
		turnRight();
		move();
		turnRight();
		fillRow();
		turnAndFill();
	}else {
		doADance();
	}
}

private void facingNorthOnWhite(){
	if (rightIsClear()){
	turnRight();
	move();
	turnRight();
	putBeeper();
		if (frontIsClear()) {
			move();
		}
	fillRow();
	turnAndFill();
	} else {
		doADance();
	}
}

private void facingSouthOnBlack(){
	if (leftIsClear()){
		turnLeft();
		move();
		turnLeft();
		fillRow();
		turnAndFill();
	} else {
		doADance();
	}
}

private void facingSouthOnWhite(){
	if (leftIsClear()){
	turnLeft();
	move();
	turnLeft();
	putBeeper();
		if (frontIsClear()) {
			move();
		}
	fillRow();
	turnAndFill();
	} else {
		doADance();
	}
}

private void doADance(){
	//Really this method is completely unnecessary, but Karel 
	//turning around a couple of times signifies that the program
	//has finished
	turnLeft();
	turnLeft();
	turnLeft();
	turnLeft();
	turnLeft();
	turnLeft();
	turnLeft();
}
}

