
// Lab11Bst.java
// The Graphics Array
// This is the student, starting file for Lab 11B.

import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class Lab11B extends Applet
{
	private int numBars;	// number of bars to be displayed
	int barHeight[];		// array of bar heights
	int swapDelay;          // The delay between the original display and the second display.
	int bar1, bar2;         // Indexes of 2 bars to be swapped.

	public void init()
	{
		numBars = enterIntGUI("How many bars will be displayed?  {1-1000}");
		bar1 = enterIntGUI("What is the index of the 1st bar to be swapped?  {0-"+(numBars-1)+"}");
		bar2 = enterIntGUI("What is the index of the 2nd bar to be swapped?  {0-"+(numBars-1)+"}");
		swapDelay = 3000;
		barHeight = new int[numBars];
		getBarValues();		
	}

	public void getBarValues()
	{
		for(int k = 0; k < numBars; k++){
			barHeight[k] = Expo.random(10, 640);
		}

	}
	
	public void paint(Graphics g) 	
	{
		displayBars(g);
		Expo.delay(swapDelay);
		swapBars(bar1,bar2);
		Expo.setBackground(g,Expo.white);
		displayBars(g);			
	}



	public static int enterIntGUI(String prompt)  
				// Allows GUI keyboard input of an integer in a graphics program.
	{
		String tempString = JOptionPane.showInputDialog(prompt);
		int temp = Integer.parseInt(tempString);
		return temp;
	}	
			

	public void displayBars(Graphics g)
	{ 	
		int temp = 20;
		
		for(int k = 0; k < numBars; k++){
			if (k == bar1 || k == bar2){
				Expo.setColor(g, Expo.blue);
			}
			else{
				Expo.setColor(g, Expo.red);
			}
			
			
			Expo.fillRectangle(g, 0, temp, barHeight[k], temp+10);
	
			
			
			temp = temp + 20;
		
		}
	} 	
	


  	private void swapBars(int x, int y)
  	{
  		int temp1 = barHeight[bar1];
  		int temp2 = barHeight[bar2];
  		
  		barHeight[bar1] = temp2;
  		barHeight[bar2] = temp1;
	
	}

}    



