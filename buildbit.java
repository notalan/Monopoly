else if (thisplayer.getNumProperties() > 1 && thisplayer.getBalance() >= 700) {
			Property property = thisplayer.getLatestProperty();
			if(property instanceof Site){
				Site site = (Site) property;
				if(site.getNumHouses() <= 3){
					if (thisplayer.isGroupOwner(site)) {
						System.out.println("colour group owner");
							if (!site.isMortgaged()) {
								System.out.println("lmao building houses " + thisplayer.getBalance());
								String name = property.getName();
								return "build" + name + "3";
							}
					}

				}	
			}
			hasRolled = false;
			return "done";
		}
