import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rpg {
	
	public static void swordRNG(String[][] levels) {
		
		ArrayList<String> weaponNames = new ArrayList<>(Arrays.asList("Excalibur", "Sting", "Ebony Blade", "Aerondight"));
		Random random = new Random();
		for (int row = 0; row < levels.length; row++) {
			
			for (int col = 0; col < levels[row].length; col++) {
				if (levels[row][col].equalsIgnoreCase("sword")) {
					int sword = random.nextInt(weaponNames.size());
					levels[row][col] = weaponNames.get(sword);
					weaponNames.remove(sword);
				}
			}
		}
	}
	
	public static void showItems(ArrayList<String> pocket) {
		StringBuilder items = new StringBuilder();
		
		if (pocket.size() == 0) {
			System.out.println("Your Inventory is empty");
		} else {
			for (int i = 0; i<pocket.size(); i++) {
				items.append((i+1)+") ");
				items.append(pocket.get(i)+ "\n");
			}
			System.out.println(items);
		}
	}
	
	public static void lookAround(String[][] levels, int curLevel, int curRoom) {
		if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
            System.out.println("In this room you can see one of Malthael's Angels of Death");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("Excalibur")) {
            System.out.println("In this room you can see Excalibur, the legendary sword of King Arthur");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("Ebony Blade")) {
            System.out.println("In this room you can see the Ebony Blade, a two-handed sword. Which is a Daedric Artifact belonging to the Daedric Princess Mephala");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("Sting")) {
            System.out.println("In this room you see a powerful ancient Elvish sword called Sting");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("Aerondight")) {
            System.out.println("This room appears to have a sword called Aerondight. This is a silver sword for fighting monsters, it was once given to a witcher by the Lady of the Lake. But now it lies here in this room");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("nothing")) {
            System.out.println("There is nothing in this room");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("stairs up")) {
            System.out.println("You can see stairs leading up");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("stairs down")) {
            System.out.println("In this room you can see stairs leading down");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("magic stones")) {
            System.out.println("In this room you can see incredibly bright stones");
        } else if (levels[curLevel][curRoom].equalsIgnoreCase("boss")) {
            System.out.println("In this room you see The Reaper of Souls, the fallen Archangel who is now the Angel of Death. You must defeat him before he kills you and everyone who stands in his way");
        }
	}
	
	public static void help() {
		System.out.println("In this game you can enter these commands:");
		System.out.println("-Inventory: Opens your inventory"); 
		System.out.println("-Grab: Picks up an item");
		System.out.println("-Drop: Drops an item you select");
		System.out.println("-Look: Shows you what's in the room");
		System.out.println("-Left, Right, Up, and Down: Moves you in the respective directions");
		System.out.println("-Fight: Hits an enemy and kills it");
		System.out.println("-Run: If a monster is present, you run back to the room you came from");
		System.out.println("-Quit: Exits the game");
	}
	
	public static void welcome() {
		System.out.println("--Welcome to the Pandemonium!--");
		System.out.println("--In this game you will traverse the Pandemonium looking for items that will help you in your journey to defeat the final boss.--");
		System.out.println("--Now you may begin your adventure.--");
		System.out.println("--Also if you need help or want to look at the available commands type help.--");
	}
	
	public static boolean grab(String[][] levels, ArrayList<String> pocket, int curLevel, int curRoom) {
		boolean gameOver = false;
		if (levels[curLevel][curRoom].equalsIgnoreCase("nothing")) {
			System.out.println("There's nothing to grab here");
			
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("magic stones")) {
			pocket.add(levels[curLevel][curRoom]);
		    System.out.println("You picked up " + levels[curLevel][curRoom]);
		    levels[curLevel][curRoom] = "nothing";
		    
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("Aerondight")) {
			pocket.add("Aerondight");
			System.out.println("You picked up Aerondight");
		    levels[curLevel][curRoom] = "nothing";
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("Excalibur")) {
			pocket.add("Excalibur");
		    System.out.println("You picked up Excalibur");
		    levels[curLevel][curRoom] = "nothing";
		    
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("Sting")) {
			pocket.add("Sting");
		    System.out.println("You picked up Sting");
		    levels[curLevel][curRoom] = "nothing";
		    
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("Ebony Blade")) {
			pocket.add("Ebony Blade");
		    System.out.println("You picked up Ebony Blade");
		    levels[curLevel][curRoom] = "nothing";
		    
		} else if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper's Sickles")) {
			pocket.add("Reaper's Sickles");
		    levels[curLevel][curRoom] = "nothing";
		    System.out.println("Congratulations! You have have defeated Malthael and now you have finished the game, play again and see how fast you can kill Malthael");
		    gameOver = true;
		}
		
		return gameOver;
	}
	
	public static boolean checkForSword(ArrayList<String> pocket) {
		boolean checker = false;
		String[] swordNames = {"Excalibur", "Sting", "Ebony Blade", "Aerondight"};
		aa:
		for (int i = 0; i<pocket.size(); i++) {
			for (int j = 0; j<swordNames.length; j++) {
				if (pocket.get(i).equals(swordNames[j])) {
					checker = true;
					pocket.remove(i);
					break aa;
				}
			}
		}	
		return checker;
	}	
	
	public static void main(String[] Args) {
		String[][] levels = {
				{"Sword", "Reaper", "Nothing", "Stairs Up", "Sword"},
				{"Stairs Up", "Reaper", "Sword", "Stairs Down", "Magic Stones"},
				{"Stairs Down", "Sword", "Reaper", "Nothing", "Boss"}
		};
		
		swordRNG(levels);
		
		ArrayList<String> pocket = new ArrayList<String>();
		
		boolean gameOver = false;
		
		//Sala inicial
		int curRoom = 0;
		//Andar inicial
		int curLevel = 0;
		
		welcome();
		lookAround(levels, curLevel, curRoom);
		
		Scanner in = new Scanner(System.in);
		while (!gameOver) {
			
			System.out.println("Type your command: ");
			String command = in.nextLine();
			
			if (command.equalsIgnoreCase("Quit")) {
				gameOver = true;
				System.out.println("You have exited the Pandemonium, return whenever you feel like you are capable of defeating the Reaper of Souls and his forces");
				
			} else if (command.equalsIgnoreCase("Help")) {
				help();

			} else if (command.equalsIgnoreCase("Inventory")) {
				showItems(pocket);
				
			} else if (command.equalsIgnoreCase("Grab")) {
			    gameOver = grab(levels, pocket, curLevel, curRoom);
			    
			} else if (command.equalsIgnoreCase("Drop")) {
				if (pocket.size() == 0) {
					System.out.println("You have nothing in your Inventory");
				} else if (levels[curLevel][curRoom].equalsIgnoreCase("Boss") || levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
					System.out.println("You can't drop an item with a monster around");
				} else if (levels[curLevel][curRoom].equalsIgnoreCase("Stairs Down") || levels[curLevel][curRoom].equalsIgnoreCase("Stairs Up")) {
					System.out.println("You can't drop items on the staircase");
				} else if (levels[curLevel][curRoom].equalsIgnoreCase("nothing")) {
					System.out.println("What do you want to drop?");
					boolean noItem = false ;
					String item = in.nextLine();
					bb:
					for (int i = 0; i<pocket.size(); i++) {
						noItem = false;
						if (item.equalsIgnoreCase(pocket.get(i))) {
							pocket.remove(i);
							levels[curLevel][curRoom] = item;
							noItem = false;
							break bb;
						} else {
							noItem = true;
						}
					}
					if(noItem == true) {
						System.out.println("That item is not in your Inventory");
					}
				} else {
					System.out.println("You can't drop an item before picking up the item in this room");
				}
			} else if (command.equalsIgnoreCase("Look")) {
				lookAround(levels, curLevel, curRoom);
				
			} else if (command.equalsIgnoreCase("Left")) {
		        if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
		        	System.out.println("The Reaper has eaten you, try again.");
		            gameOver = true;
		        } else if (curRoom == 0) {
		        	System.out.println("Can't move left, there is a wall there");
				} else {
					curRoom -= 1;
					lookAround(levels, curLevel, curRoom);
		        }  
			} else if (command.equalsIgnoreCase("Right")) {
				if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
					System.out.println("The Reaper has eaten you, try again.");
		            gameOver = true;
		            
		        } else if (curRoom == levels[curLevel].length -1) {
		        	System.out.println("Can't move right, there is a wall there");
		        } else {
		        	curRoom += 1;
		            lookAround(levels, curLevel, curRoom);
		        }
			} else if (command.equalsIgnoreCase("Up")) {
				if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
					System.out.println("The Reaper has eaten you, try again.");
					gameOver = true;
				} else if (!levels[curLevel][curRoom].equalsIgnoreCase("stairs up")) {
					System.out.println("Can't go up, there are no stairs leading up");
				} else if (curLevel == 0) {
					curLevel = 1;
					lookAround(levels, curLevel, curRoom);
				} else if (curLevel == 1) {
					curLevel = 2;
					lookAround(levels, curLevel, curRoom);
				}
			} else if (command.equalsIgnoreCase("Down")) {
				if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
					System.out.println("The Reaper has eaten you, try again");
		            gameOver = true;
		            
		         } else if (!levels[curLevel][curRoom].equalsIgnoreCase("stairs down")) {
		        	 System.out.println("Can't go down, there are no stairs leading down");
		        	 
		         } else if (curLevel == 2) {
		        	 curLevel = 1;
		             lookAround(levels, curLevel, curRoom);
		             
		         }else if (curLevel == 1) {
		              curLevel = 0;
		              lookAround(levels, curLevel, curRoom); 
		         }
		    } else if (command.equalsIgnoreCase("Fight")) {
		    	if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
		    		boolean sword = checkForSword(pocket);
		    		if (sword == true) {
		    			levels[curLevel][curRoom] = "nothing";
		    			System.out.println("You have killed a Reaper! And your sword has broken");
		    		} else {
		    			System.out.println("You have no weapon to fight with, so you have been eaten by the Reaper, try again.");
		    			gameOver = true;
		    		}
		    	} else if (levels[curLevel][curRoom].equalsIgnoreCase("Boss")) {
		    		String stones = "magic stones";
		    		for (int i = 0; i<pocket.size(); i++) {
						if (stones.equalsIgnoreCase(pocket.get(i))) {
							pocket.remove(i);
							levels[curLevel][curRoom] = "Damaged Boss";
							System.out.println("You have used the magic stones and The Reaper of Souls has been weakened, now you can finish him with your sword");
						} else {
							System.out.println("You did not have the appropriate items to defeat Malthael, so you have succumbed. The Reaper of Souls will now control the whole world by releasing his reapers and unleashing his fury!!! If you're resurrected you must try to defeat Malthael and his reapers once again, before it is too late for humanity.\nHint: you must weaken the boss with magic stones before you hit him with your sword.");
							gameOver = true;
						}
		    		}
		    	} else if (levels[curLevel][curRoom].equalsIgnoreCase("Damaged Boss")) {
		    		boolean sword = checkForSword(pocket);
		    		if (sword == true) {
		    			levels[curLevel][curRoom] = "Reaper's Sickles";
		    			System.out.println("You have defeated Malthael, the Angel of Death. You have saved humanity and now you can grab the Reaper's Sickles and use it on your next adventures or keep it as a trophy");
		    		} else {
		    			System.out.println("You have sucumbed trying to defeat Malthael. The Reaper of Souls will now control the whole world by releasing his reapers and unleashing his fury!!! If you're resurrected you must try to defeat Malthael and his reapers once again, before it is too late for humanity.");
		    			gameOver = true;
		    		}
		    	} else if (!levels[curLevel][curRoom].equalsIgnoreCase("Reaper") || !levels[curLevel][curRoom].equalsIgnoreCase("boss")) {
		    		System.out.println("There's nothing to fight here");  
		    	}  
			} else if (command.equalsIgnoreCase("Run")) {
				if (levels[curLevel][curRoom].equalsIgnoreCase("boss")) {
					System.out.println("You can't run away from the boss, you are trapped in his room");
		        } else if (levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) {
		        	if (curLevel==1) {
		        		curRoom += 1;
		        	} else {
		        		 curRoom -= 1;
		        	}
		            System.out.println("You ran from the Reaper, now your back in the room you just came from");
		        } else if (!levels[curLevel][curRoom].equalsIgnoreCase("Reaper")) { 
					System.out.println("There is nothing to run away from");
		        } 
		    } else {
		    	System.out.println("Invalid command.");
		    }
		
		}
		in.close();
	}
}
