void initialiseTiles()//sets up all information to do with each tile
			{
				tile[0] = new House("GO", 0, 0, "", 0); // Goes name, price, rent, colour, mortgage
				tile[1] = new House("Old Kent Road",60,2,"brown",30);
				tile[2] = new House("Community Chest",0,0,"", 0);
				tile[3] = new House("Whitechapel Road",60,4,"brown",30);
				tile[4] = new House("Income Tax",-200,0,"",0);
				tile[5] = new House("King's Cross Station",200,0,"",100); // LOOK HERE WHEN MULTIPLIERS ARE DONE
				tile[6] = new House("The Angel Islington",100,6,"cyan",50);
				tile[7] = new House("Chance",0,0,"",0);
				tile[8] = new House("Euston Road",100,6,"cyan",50);
				tile[9] = new House("Pentonville Road",120,8,"cyan",60);
				tile[10] = new House("Jail/Just visiting",0,0,"",0);
				tile[11] = new House("Pall Mall",140,10,"magenta",70);
				tile[12] = new House("Electric Company",0,0,"",75); // COME HERE TOO
				tile[13] = new House("Whitehall",140,10,"magenta",70);
				tile[14] = new House("Northumberland Avenue",160,12,"magenta",80);
				tile[15] = new House("Fenchurch Street Station",200,0,"",100); // COME HERE TOO
				tile[16] = new House("Bow Street",180,14,"orange",90);
				tile[17] = new House("Community Chest",0,0,"",0); // COME HERE TOO
				tile[18] = new House("Marlbourogh Street",180,14,"orange",90);
				tile[19] = new House("Vine Street",200,16,"orange",100);
				tile[20] = new House("Free Parking",0,0,"",0);
				tile[21] = new House("The Strand",220,18,"red",110);
				tile[22] = new House("Chance",0,0,"",0);
				tile[23] = new House("Fleet Street",220,18,"red",110);
				tile[24] = new House("Trafalgar Square",240,20,"red",120);
				tile[25] = new House("Marylebone Station",200,0,"",100); // COME HERE TOO
				tile[26] = new House("Leicester Square",260,22,"yellow",130);
				tile[27] = new House("Coventry Street",260,22,"yellow",130);
				tile[28] = new House("Water Works",0,0,"",75); // COME HERE TOO
				tile[29] = new House("Picadilly",280,22,"yellow",140);
				tile[30] = new House("Go to Jail!",0,0,"",0);
				tile[31] = new House("Regent Street",300,26,"green",150);
				tile[32] = new House("Oxford Street",300,26,"green",150);
				tile[33] = new House("Community Chest",0,0,"",0);
				tile[34] = new House("Bond Street",320,28,"green",160);
				tile[35] = new House("Liverpool Street Station",200,0,"",100); // COME HERE TOO
				tile[36] = new House("Chance",0,0,"",0);
				tile[37] = new House("Park Lane",350,35,"blue",175);
				tile[38] = new House("Luxary Tax",-100,0,"",0);
				tile[39] = new House("Mayfair",400,50,"blue",200);		
				
				// There are some cases where it depends on the amount you own, the train stations and the utilities
//				tile[5].setRent("King's Cross Station"); // Depends on amount of stations you own 25,50,100,200
//				tile[12].setRent("Electric Company"); // If own 1 utility 4* dice roll
//				tile[15].setRent("Fenchurch Street Station");
//				tile[25].setRent("Marylebone Station");
//				tile[28].setRent("Water Works"); // If own both utilities 10* dice roll is rent
//				tile[35].setRent("Liverpool Street Station");
			}
		
		boolean ColourGroupCheck(int lol, String tilecolour) // Checks if the properties are all in the same colour group 
		{
			for (House PropertyName : tile) // iterates through the tile list
			{
				if(PropertyName.getColour().equals(tilecolour) && PropertyName.getOwner() != player[lol].PlayerName()) // Checks if the player owns all the properties of that colour
				{
					return false;
				}
			}
			
			return true;
		}
		
		public String BuildHouses(int lol) // Part that builds houses.
		{
			if(ColourGroupCheck(lol, tile[player[lol].position].getColour()) == true)
			{
				String HouseBuild = JOptionPane.showInputDialog(null, "Do you want to build a house?");
				if(HouseBuild == "Yes")
				{
					tile[player[lol].position].NumOfHouses++;
					player[pCount].debt(tile[player[pCount].position].PriceOfHouse);
					return "There is/are" + tile[player[lol].position].NumOfHouses + "Houses here.";
				}
			}
			return "kek";
		}
		
//		public void BuildHotels(Player player, House NumOfHotels, House NumOfHouses)
//		{
//			if(int NumOfHouses = 4)
//			{
//				String HotelBuild = JOptionPane.showInputDialog(null, "Do you want to build a hotel?");
//				if (HotelBuild == "Yes")
//				{
//					NumOfHotels = 1;
//					NumOfHouses = 0;
//					player[pCount].debt(tile[player[pCount].position].PriceOfHotel;
//					return "You have built a hotel";
//
//				}
//			}
//		}
		
}
