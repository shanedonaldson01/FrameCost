import java.text.*;
import javax.swing.JOptionPane;

public class FrameCost {
	
	//declare constant variables
	static final double COLORCOST = .1;
	static final double FRAMECOST = .15;
	static final double FANCYCOST = .25;
	static final double CARDBOARDCOST = .02;
	static final double GLASSCOST = .07;
	static final double CROWNCOST = .35;

	public static void main(String[] args) {
		//declare variables
		String color, frameType, addCrown, outBreakdown, outTot, outGrandTot;
		double length = 0, width = 0, sqrIn = 0;
		double frameTot = 0, cardboardTot = 0, colorTot = 0, glassTot = 0, crownTot = 0, purchaseTot = 0;
		int crowns = 0;
		
		//create new format object to limit decimals to two places
		DecimalFormat df = new DecimalFormat("#.00");
		
		//receive input from user for length and width
		String strLength = JOptionPane.showInputDialog("Please enter the length of the frame ");
		length = Integer.parseInt(strLength);
		
		String strWidth = JOptionPane.showInputDialog("Please enter the width of the frame ");
		width = Integer.parseInt(strWidth);
		
		//prompt user for frame type, and calculate cost based on which was chosen
		frameType = JOptionPane.showInputDialog("Would you like a regular or fancy frame? regular/fancy: ");
		if(frameType.toLowerCase().equals("regular"))
		{
			frameTot = FRAMECOST * ((length + width) * 2);
		}
		else if(frameType.toLowerCase().equals("fancy"))
		{
			frameTot = FANCYCOST * ((length + width) * 2);
		}
		
		//prompt user for color, and calculate cost based on which was chosen
		color = JOptionPane.showInputDialog("What color would you like the frame to be? ");
		if(color.toLowerCase().equals("white"))
		{
			colorTot = 0;
		}
		else
		{
			colorTot = COLORCOST * ((length + width) * 2);
		}		
		
		//prompt user for crowns, and calculate cost based on which was chosen
		addCrown = JOptionPane.showInputDialog("Would you like to add crowns? yes/no: ");
		if(addCrown.toLowerCase().equals("yes"))
		{
			String strCrowns = JOptionPane.showInputDialog("How many crowns would you like to add? ");
			crowns = Integer.parseInt(strCrowns);
		}
		else if(addCrown.toLowerCase().equals("no"))
		{
			crowns = 0;
		}
		
		//calculate totals for the remaining input
		sqrIn = length * width;
		cardboardTot = sqrIn * CARDBOARDCOST;
		glassTot = sqrIn * GLASSCOST;
		crownTot = crowns * CROWNCOST; 
		purchaseTot = frameTot + cardboardTot + glassTot + colorTot + crownTot;
		
		//output the users choices back to them
		outBreakdown = ("\nYour frame's length is: " + length + " inches" + "\n" +
						   "Your frame's width is: " + width + " inches" + "\n" +
						   "You chose a " + frameType + " frame" + "\n" +
						   "You chose the color " + color + " for your frame" + "\n" +
						   "You added " + crowns + " crowns to your frame" + "\n");
		//output a breakdown of each cost 
		outTot = ("Frame:        $" + df.format(frameTot) + "\n" +
				  "Color:        $" + df.format(colorTot) + "\n" +
				  "Cardboard:    $" + df.format(cardboardTot) + "\n" +
				  "Glass:        $" + df.format(glassTot) + "\n" +
				  "Crowns:       $" + df.format(crownTot) + "\n");
		//output total frame cost
		outGrandTot = ("Your frame total is: $" + df.format(purchaseTot));
		
		//display output to dialog box
		JOptionPane.showMessageDialog(null, outBreakdown, "Your Order", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, outTot, "Your Order Costs", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, outGrandTot, "Your Order Total", JOptionPane.INFORMATION_MESSAGE);
	}
}
