import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class WeDemKois implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects
	boolean hasRolled = false;
	PlayerAPI thisplayer;
	BoardAPI thisboard;
	DiceAPI thisroll;
	WeDemKois (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		thisplayer = player;
	    thisboard = board;
	    thisroll = dice;
		return;
	}

	public String getName () {
		return "WeDemKois";
	}
	
	public String getCommand () {
		try { // THIS SLOWS IT DOWN
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(thisplayer.isInJail())
		{
			if(thisplayer.hasGetOutOfJailCard())
			{
				return "card";
			}
			else if(thisplayer.getBalance() >= 500)
			{
				return "pay";
			}
			else if(!hasRolled){
					hasRolled = true;
					return "roll";
			}
			else{
					hasRolled = false;
					return "done";
			}
		}
		else if(thisplayer.getBalance() < 0){
			if(thisplayer.getNumProperties() == 0){
				return "bankrupt";
			}
			String property = getLowestValuePropery();
			System.out.println("balance after mortgage: "+Integer.toString(thisplayer.getBalance()));
			return "mortgage " + property;
		}
		else if(!hasRolled){//roll your dice
			hasRolled = true;
			return "roll";
		}
		else if(thisplayer.getBalance() > 700){
			ArrayList<Property> list = new ArrayList<Property>();
			list = thisplayer.getProperties();
			for(int i = 0; i < thisplayer.getNumProperties(); i++){
				Property p;
				p = list.get(i);
				if(p.isMortgaged()){
					return "redeem" + p.getShortName();
				}
			}
			if(!hasRolled){//roll your dice
				hasRolled = false;
				return "roll";
			}
			else if(hasRolled == true)
			{
				return "done";
			}
		}
		
		else if(thisboard.isProperty(thisplayer.getPosition())) {//if the tile can be bought
			if(thisplayer.getPosition() == 1 || thisplayer.getPosition() == 3 || thisplayer.getBalance() < thisboard.getProperty(thisplayer.getPosition()).getPrice()){
				hasRolled = false;
				return "done";//don't buy
			}
			if(thisplayer.getBalance() > 400 && !thisboard.getProperty(thisplayer.getPosition()).isOwned()){//if bot has over 400 and the property isn't owned
				System.out.println("balance after buy: "+Integer.toString(thisplayer.getBalance()));
				return "buy";
			}
			else{
				hasRolled = false;
				return "done";
			}
		}
		else{
				hasRolled = false;
				return "done";
			}
	}
	
	public String getDecision () {
		if(thisplayer.getBalance() >= 500)
		{
			System.out.println(Integer.toString(thisplayer.getBalance()));
			return "pay";
		}
		else
			return "chance";
	}
	
	String getLowestValuePropery(){
		String leastVal = "";
		Property p;
		int temp = 20000;
		ArrayList<Property> list = new ArrayList<Property>();
		list = thisplayer.getProperties();
		for(int i = 0; i < thisplayer.getNumProperties(); i++){
			p = list.get(i);
			if(p.getRent() < temp && !p.isMortgaged()){
				temp = p.getRent();
				leastVal = p.getShortName();
			}
		}
		return leastVal;
	}
}
