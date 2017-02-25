//WeDemKois
//Liam Braiden 15337941
//Connor Clancy 15528697 
//Alan Cheng 15440552
// class creates the board and players and paints them onto the frame
// it also has the main where the looping of players takes place

import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

	public class Board extends JFrame
	{
		static int xCo_ord[] = new int[7];// Starting Coordinates of players
		static int yCo_ord[] = new int[7];

		private static final long serialVersionUID = 1L;
		
	    public Board() 
	    {
	    	for(int i = 0; i < 7; i++){    	
	    	xCo_ord[i] = 20;
	    	yCo_ord[i] = 30;
	    	}
	    }
	    
	    void drawLines(Graphics g) 
	    {
	        Graphics2D Graphics2dim = (Graphics2D) g;
	  
	        Graphics2dim.drawLine(0, 100, 800, 100); // Top line of the board
	   	 
	        Graphics2dim.draw(new Line2D.Double(100, 0, 100, 100)); // Top left box
	        Graphics2dim.draw(new Line2D.Double(700, 0, 700, 100)); // Top right box
	        Graphics2dim.draw(new Line2D.Double(700, 800, 700, 100)); // Bottom left box
	        Graphics2dim.draw(new Line2D.Double(100, 800, 100, 100)); // Bottom right box
	        Graphics2dim.draw(new Line2D.Double(800, 700, 0, 700)); // Top right box
	        Graphics2dim.draw(new Line2D.Double(800, 0, 800, 800)); //closing the right hand side
	        Graphics2dim.draw(new Line2D.Double(0, 800, 800, 800)); //closing the bottom of it
	        
	        Graphics2dim.draw(new Line2D.Double(166.6, 0, 166.6, 100)); // Top row of board
	        Graphics2dim.draw(new Line2D.Double(233.2, 0, 233.2, 100)); // Works as X1,Y1,X2,Y2
	        Graphics2dim.draw(new Line2D.Double(299.8, 0, 299.8, 100)); 
	        Graphics2dim.draw(new Line2D.Double(366.4, 0, 366.4, 100));
	        Graphics2dim.draw(new Line2D.Double(433, 0, 433, 100));
	        Graphics2dim.draw(new Line2D.Double(499.6, 0, 499.6, 100));
	        Graphics2dim.draw(new Line2D.Double(566.2, 0, 566.2, 100));
	        Graphics2dim.draw(new Line2D.Double(632.8, 0, 632.8, 100));
	        Graphics2dim.draw(new Line2D.Double(699.4, 0, 699.4, 100));
	        
	        Graphics2dim.draw(new Line2D.Double(0, 166.6, 100, 166.6)); // Left row of board
	        Graphics2dim.draw(new Line2D.Double(0, 233.2, 100, 233.2));
	        Graphics2dim.draw(new Line2D.Double(0, 299.8, 100, 299.8));
	        Graphics2dim.draw(new Line2D.Double(0, 366.4, 100, 366.4));
	        Graphics2dim.draw(new Line2D.Double(0, 433, 100, 433));
	        Graphics2dim.draw(new Line2D.Double(0, 499.6, 100, 499.6));
	        Graphics2dim.draw(new Line2D.Double(0, 566.2, 100, 566.2));
	        Graphics2dim.draw(new Line2D.Double(0, 632.8, 100, 632.8));
	        Graphics2dim.draw(new Line2D.Double(0, 699.4, 100, 699.4));
        
	        Graphics2dim.draw(new Line2D.Double(700, 166.6, 800, 166.6)); // Right row of board
	        Graphics2dim.draw(new Line2D.Double(700, 233.2, 800, 233.2));
	        Graphics2dim.draw(new Line2D.Double(700, 299.8, 800, 299.8));
	        Graphics2dim.draw(new Line2D.Double(700, 366.4, 800, 366.4));
	        Graphics2dim.draw(new Line2D.Double(700, 433, 800, 433));
	        Graphics2dim.draw(new Line2D.Double(700, 499.6, 800, 499.6));
	        Graphics2dim.draw(new Line2D.Double(700, 566.2, 800, 566.2));
	        Graphics2dim.draw(new Line2D.Double(700, 632.8, 800, 632.8));
	        Graphics2dim.draw(new Line2D.Double(700, 699.4, 800, 699.4));
	        
	        Graphics2dim.draw(new Line2D.Double(166.6, 700, 166.6, 800)); // Bottom row of board
	        Graphics2dim.draw(new Line2D.Double(233.2, 700, 233.2, 800));
	        Graphics2dim.draw(new Line2D.Double(299.8, 700, 299.8, 800));
	        Graphics2dim.draw(new Line2D.Double(366.4, 700, 366.4, 800));
	        Graphics2dim.draw(new Line2D.Double(433, 700, 433, 800));
	        Graphics2dim.draw(new Line2D.Double(499.6, 700, 499.6, 800));
	        Graphics2dim.draw(new Line2D.Double(566.2, 700, 566.2, 800));
	        Graphics2dim.draw(new Line2D.Double(632.8, 700, 632.8, 800));
	        Graphics2dim.draw(new Line2D.Double(699.4, 700, 699.4, 800));
	        
	       
			Font font1 = new Font("Comic Sans", Font.BOLD, 10);// This changes the font to papyrus and changes it to size 14
			Graphics2dim.setFont(font1); // This sets the font for the text on the tiles
			
	        g.setColor(Color.black); // Changes the text colour to black
	        g.drawString("GO!", 40, 785);
	        g.drawString("Jail/just visiting", 4, 85);
	        g.drawString("Free Parking", 715, 85);
	        g.drawString("GO to Jail!", 715, 785);
	        
	        g.drawString("Community",6,610); // Left community chest
	        g.drawString("Chest",6,623);
	        
	        g.drawString("Community",501,79); // Top community chest
	        g.drawString("Chest",501,95);
	        
	        g.drawString("Community",501,775); // Bottom community chest
	        g.drawString("Chest",501,790);
	        
	        g.drawString("Chance",55,290); // Chance left
	        g.drawString("Chance",705 ,225); // Chance right
	        g.drawString("Chance",305 ,795); // Chance bottom
	        
	        g.drawString("Electric",168,79); // Tile names
	        g.drawString("Company",168 ,95);		      
	        g.drawString("Water",701 ,605);
	        g.drawString("Works",701 ,620);
	        
	        g.drawString("Income",15,480); // Tile names
	        g.drawString("Tax",25,490);	       
	        g.drawString("Luxary",185,780);
	        g.drawString("Tax",185,790);
	        
	        g.drawString("Old Kent",10,675); // Brown tiles names
	        g.drawString("Road",10,690);
	        g.drawString("Whitechapel", 10,545);
	        g.drawString("Road", 10,560);
	        
	        g.drawString("The Angel",10,350); // Cyan/Light blue tiles names
	        g.drawString("Islington",10,365);
	        g.drawString("Euston", 10,215);
	        g.drawString("Road", 10,230);
	        g.drawString("Pentonville", 10,145);
	        g.drawString("Road", 10,160);
	        
	        g.drawString("Pall",120,30); // Magenta/Pink tiles names
	        g.drawString("Mall",120,45);
	        g.drawString("Whitehall", 240,30);
	        g.drawString("Northumber-", 300,30);
	        g.drawString("land", 300, 45);
	        g.drawString("Avenue", 300,60);
	        
	        g.drawString("Bow", 460,30); // Orange tiles names
	        g.drawString("Street", 455,45);
	        g.drawString("Marlbourogh", 565,30);
	        g.drawString("Street", 580,45);
	        g.drawString("Vine", 646,30);
	        g.drawString("Street", 646,45);
	        
	        g.drawString("The", 755,150); // Red tiles names
	        g.drawString("Strand", 755,165);
	        g.drawString("Fleet", 755,280);
	        g.drawString("Street", 750,295);
	        g.drawString("Trafalgar", 750,345);
	        g.drawString("Square", 750,360);
	        
	        g.drawString("Leicester", 750,480); // Yellow tiles names
	        g.drawString("Square", 750,495);
	        g.drawString("Coventry", 750,550);
	        g.drawString("Street", 750,565);
	        g.drawString("Picadilly", 750,690);

	        g.drawString("Regent", 650,780); // Green tiles names
	        g.drawString("Street", 650,795);
	        g.drawString("Oxford", 580,780);
	        g.drawString("Street", 580,795);
	        g.drawString("Bond", 450,780);
	        g.drawString("Street", 450,795);
	        
	        g.drawString("Park", 255,780); // Blue tiles names
	        g.drawString("Lane", 255,795);
	        g.drawString("Mayfair", 115,790);
	        		        
	        g.drawString("King's Cross", 10,410); // Trains left
	        g.drawString("Station", 10,425);
	        g.drawString("Marylebone",735 ,410); // Right
	        g.drawString("Station",735,425 );
	        g.drawString("Fenchurch St.",368,79); // Top
	        g.drawString("Station",368,90);
	        g.drawString("Liverpool",370 ,775);// Bottom
	        g.drawString("Street", 370,785);		        
	        g.drawString("Station", 370,795);
	    }
	 
	    
	    public void drawPlayers(Graphics g) {
	    	    g.setColor(Color.CYAN); 
	        	g.fillOval(xCo_ord[0] , yCo_ord[0] +40, 15, 15);
	        	
	        	g.setColor(Color.MAGENTA);
	        	g.fillOval(xCo_ord[1] ,yCo_ord[1] + 20 ,15 ,15);
	        	
	        	g.setColor(Color.YELLOW);
	        	g.fillOval(xCo_ord[2] ,yCo_ord[2] ,15 ,15);
	        	
	        	g.setColor(Color.BLUE);
	        	g.fillOval(xCo_ord[3] + 20 ,yCo_ord[3] ,15 ,15);
	        	
	        	g.setColor(Color.DARK_GRAY);
	        	g.fillOval(xCo_ord[4] + 20, yCo_ord[4] + 20, 15, 15);
	        	
	        	g.setColor(Color.ORANGE);
	        	g.fillOval(xCo_ord[5] + 20, yCo_ord[5] + 40, 15, 15);
	    }
	    
	    public void paint(Graphics g) 
	    {
	        super.paint(g);
	        drawLines(g);
	        drawPlayers(g);
	        Color brown = new Color(139,69,19); // Using RGB to make brown
	        
	        g.setColor(Color.cyan); // Changes colour of the rectangle (which is the property colour)
	        g.fillRect(80,101,20,65); // X1 Y1 X2 Y2. The last 2 numbers round the edges
	        g.fillRect(80,167,20,65); 
	        g.fillRect(80,301,20,65); // Cyan properties (light blue)
	        
	        g.setColor(brown);
	        g.fillRect(80,633,20,66);
	        g.fillRect(80,500,20,66);
	        
	        g.setColor(Color.yellow);
	        g.fillRect(701,633,20,65);
	        g.fillRect(701,501,20,65);
	        g.fillRect(701,434,20,65);
	        
	        g.setColor(Color.red);
	        g.fillRect(701,301,20,65);
	        g.fillRect(701,234,20,65);
	        g.fillRect(701,100,20,65);
	        
	        g.setColor(Color.magenta);
	        g.fillRect(301,79,65,20);
	        g.fillRect(234,79,65,20);
	        g.fillRect(101,79,65,20);
	        
	        g.setColor(Color.orange);
	        g.fillRect(634,79,65,20);
	        g.fillRect(567,79,65,20);
	        g.fillRect(434,79,65,20);
	        
	        g.setColor(Color.blue);
	        g.fillRect(101,701,65,20);
	        g.fillRect(234,701,65,20);
	        
	        g.setColor(Color.green);
	        g.fillRect(434,701,65,20);
	        g.fillRect(567,701,65,20);
	        g.fillRect(634,701,65,20);

	    }
	    
	    public static void main(String[] args) throws InterruptedException// exception used for sleep method
, IOException
	    {
	    	
	    	IOPanel console = new IOPanel(); // Calls the console
	    	Board monopoly = new Board();
	    	
	        monopoly.setBounds(100, 20, 1124, 800); // Size
	        monopoly.setUndecorated(true);
	        JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, console.panel, console.panel1); // Splits the east side of the panel to fit the console
	    	monopoly.add(pane, BorderLayout.EAST);
	    	
	    	URL img = new URL("http://i64.tinypic.com/2jbk6ee.png");
	    	ImageIcon image = new ImageIcon(img);
	    	JLabel picLabel = new JLabel("", image, JLabel.CENTER);
	    	monopoly.add(picLabel, BorderLayout.CENTER);
	    	
	    	monopoly.setVisible(true);
	    	Color back = new Color(192, 226, 202); // Makes the colour of the board using RGB
	    	monopoly.getContentPane().setBackground(back);	
	    	monopoly.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    	console.Area.append("Type \"help\" in box above and hit enter\nto begin:\n");
	    	
	    	
	    	
	    	while(console.endVal != 0){// end game, doesn't work
	    		while(!console.Field.getText().equals("End turn")){// updates which player it is getting coordinates from
	    			xCo_ord[console.pCount] = console.player[console.pCount].getPlayerx();
	    			yCo_ord[console.pCount] = console.player[console.pCount].getPlayery();
	    			TimeUnit.SECONDS.sleep(2);// wait for a second before moving the platers more
		    		monopoly.repaint();
	    		}
	    	}
	    }
	}
