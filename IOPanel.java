
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class IOPanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;// this is there bc eclipse told me to put it here
	
	JTextField Field = new JTextField(25);
	JTextArea Area = new JTextArea(40, 25);
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	
	Player player[] = new Player[6];
	public int pCount = 0, pMax = 0;
	
	int endVal = 1;
	int startGame = 0;
	
	IOPanel()
	{	
    panel1.setBounds(191, 50, 300, 400);// 191 =x, 50 = y, 300 = width, 400 = height
    JScrollPane scrollPane = new JScrollPane(Area);// area becomes scrollPane
    panel1.add(scrollPane);// add scrollPane to the panel
    
    panel.setBounds(250,0,100,50);
    Field.addActionListener(this);// used for detecting when user inputs stuff
    Field.setBorder(BorderFactory.createLineBorder(Color.black, 5));// border 4 fun
    panel.add(Field);// add the text field to the panel
      
    int i = 0;
	while(i < 6)
		{
		player[i] = new Player();
		i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		String input = Field.getText();// listener gets text input from user
        Area.append(input + "\n" + "type \"help\" to see all commands\n");// adding new line char so that the inputs are saved in Area, making Field clear
        Field.selectAll();// allows easy input of next command
        Area.append(commands(input) + "\n");// sends input to be processed
		
	}
	
	public String commands(String input)
	{
    	if(input.compareTo("add player") == 0)
    	{
    		if(startGame == 1)
    		{// game has started, cannot add players
    			return "nah fam";
    		}
    		if(pMax > 5)// max players
    		{
    			return "too many players";
    		}
    		else
    		{
    			pMax = pCount++;	//increase total and player count	
    			player[pCount].addName("player " + Integer.toString(pCount));//just adds "player 1", "player 2", etc..
    			return "player added";
    		}
    	}
    	else if(input.compareTo("details") == 0)
    	{//get player stats
    		return player[pCount].getPlayer();
    	}
    	else if(input.compareTo("start") == 0){// starts game, unlocks other commands
    		if(startGame == 1)
    		{// game already started cannot restart, gonna be a diff function
    			return "nah fam";
    		}
    		else
    		{
    			startGame = 1;// set game to "started" mode
    			pCount = 0;// reset to first player, unnecessary actually bc dice roll determines first player
    			return "commence!";
    		}
    	}
    	else if(input.compareTo("roll dice") == 0)
    	{// rolls 2 dice
    		if(startGame == 0)
    		{// game hasn't started yet cannot roll dice
    			return "nah fam";
    		}
    		String Dicerolls = "";
//    		String Dicerolls2 ="";
    		for(int i = 0; i < 2; i++)
    		{
//      		  int rand1 = 1 + (int)(Math.random()*2.0);// random number between 1 and 6
//      		  int rand2 = 1 + (int)(Math.random()*2.0); // 2nd dice random between 1 and 6
      		  
    			int tileCount = 0;
	    		while(tileCount < rand1)// movement around board based on dice numbers
	    		{
	    			if(player[pCount].getPlayery() > 650 && player[pCount].getPlayerx() > 100)// bottom right, start moving left
	    			{
	    				player[pCount].movePlayerx(player[pCount].getPlayerx() - 66);
	    				if(player[pCount].getPlayerx() < 100)
	    				{
	    					player[pCount].movePlayery(700);
	    					player[pCount].movePlayerx(20);
	    				}
	    			}
	    			else if(player[pCount].getPlayery() > 100 && player[pCount].getPlayerx() <= 50)// bottom left, start moving up
	    			{
	    				player[pCount].movePlayery(player[pCount].getPlayery() - 66);
	    				if(player[pCount].getPlayery() < 100)
	    				{
	    					player[pCount].movePlayery(30);
	    					player[pCount].movePlayerx(40);
	    				}
	    			}
	    			else if(player[pCount].getPlayery() <= 50 && player[pCount].getPlayerx() < 650)// top left, start moving right
	    			{
	    				player[pCount].movePlayerx(player[pCount].getPlayerx() + 66);
	    				if(player[pCount].getPlayery() >= 650)
	    				{
	    					player[pCount].movePlayery(40);
	    					player[pCount].movePlayerx(750);
	    				}
	    			}
	    			else if(player[pCount].getPlayery() <= 650 && player[pCount].getPlayerx()  > 650)// top right, start moving down
	    			{
	    				player[pCount].movePlayery(player[pCount].getPlayery() + 66);
	    				if(player[pCount].getPlayery() > 650)
	    				{
	    					player[pCount].movePlayery(720);
	    					player[pCount].movePlayerx(720);
	    				}
	    			}
	    			else
	    				Area.append("error");
	    			
	    			tileCount++;
	    		}
    		  String Dice = Integer.toString(rand1);
	    		  
//	    		  Dicerolls = rand1 + rand2 + "\n";// puts all rolls in one string and returns it
//	    		
//	    		  if(rand1 == rand2) // Checks if the numbers on the dice are the same
//	    		  {
//	    			  int rand3 = 1 + (int)(Math.random()*2.0);// random number between 1 and 6
//	
//	        		  int rand4 = 1 + (int)(Math.random()*2.0); // 2nd dice random between 1 and 6
//	
//	        		  Dicerolls2 =  rand3 + rand4 + "\n";// puts all rolls in one string and returns it
//	        		  return Dicerolls + Dicerolls2;
//	    		  }
//	    		  else 
//	    		  	{  
//	    			  return Dicerolls;
//	    		  	}	  
	    		}
	    		return Dicerolls;
    	}
    	else if(input.compareTo("End turn") == 0)
    	{
    		if(startGame == 0)
    		{// game hasn't started yet cannot end turn
    			return "nah fam";
    		}
    		pCount++;//points to next Player object in the array
    		String end = "player " + player[pCount].name + "'s turn\n";
    		return end;
    		
    	}
    	else if(input.compareTo("help")==0)
    	{
    		String commandList = "add player = Adds a new player to the game. \n";
    		String commandList1 = "roll dice = Rolls the dice.\n";
    		String commandList2 = "end turn = Ends the current players turn.\n";
    		String commandList3 = "help = Displays the list of commands. \n";
    		String commandList4 = "details = displays all current players stats\nstart = starts game, locks player adding, unlocks other commands\n";
    		commandList = commandList + commandList1 +commandList2 + commandList3 + commandList4;
    		return commandList;
    	}
    	else if(input.compareTo("end")==0)
    	{
    		if(startGame == 0)
    		{// game hasn't started yet cannot end game
    			return "nah fam";
    		}
    		endVal = 0;
    		return null;
    	}
    	else
    	{
    		String error = "unknown command";
    		return error;
    	}
    }

}
