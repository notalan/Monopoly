
public class Dice 
{
		String Dicerolls = "";
		String Dicerolls2 = "";
	
			 int rand1 = 1 + (int)(Math.random()*2.0);// random number between 1 and 6
		     int rand2 = 1 + (int)(Math.random()*2.0); // 2nd dice random between 1 and 6
		     
		     {
		     Dicerolls = rand1 + rand2 + "\n";// puts all rolls in one string and returns it
		    		  
		    		  if(rand1 == rand2) // Checks if the numbers on the dice are the same
		    		  {
		    			  int rand3 = 1 + (int)(Math.random()*2.0);// random number between 1 and 6
		        		  int rand4 = 1 + (int)(Math.random()*2.0); // 2nd dice random between 1 and 6

		        		  Dicerolls2 =  rand3 + rand4 + "\n";// puts all rolls in one string and returns it
		        		  
		        		  return Dicerolls + Dicerolls2;
		    		  }
			    		  else 
			    		  {  
			    			  return Dicerolls;
			    		  }	  
		     
		     }

}
