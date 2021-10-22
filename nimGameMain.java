/** This code allows two players to play the game NIM 
 * Two players choose 1-3 sticks out of the 4 piles which have
 * 4-8 sticks in them, the objective is to force the opponent
 * to pick up the last stick.
 * @author Muhammad Abdullah
 * October 18th 2019
 * */
import java.util.Scanner;

class nimGameMain
{
	//This method returns random numbers between 4-8 for each pile
	public static int pileNums()
	{
		int randNum = (int)(Math.random() * 4 + 4);
		return randNum;
	}
	//main method
	public static void main(String[] args)
	{
		char restartAnswer;
		//Ask and enter Player Names
		Scanner in = new Scanner(System.in);
		System.out.println("----Welcome to NIM!!----");
		System.out.println(); //blank				
		System.out.println("Player 1 enter your username: ");	
		String playerOne = in.next();
		System.out.println("Player 2 enter your username: ");
		String playerTwo = in.next();
		
		//Blank Lines
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Printing Out Rules
		System.out.println("Before you start here are the rules: ");
		System.out.println("- Each player will take turns chosing 1 out of the four piles.");
		System.out.println("- And you MUST chose from a pile that has sticks");
		System.out.println("- You will then chose a number (1-3) of sticks to remove from that pile.");
		System.out.println("- That pile MUST have the amount of sticks you chose");
		System.out.println("- The goal is to force the opponent to pick up the last stick in the pile");
		
		//Blank Lines		
		System.out.println();
		System.out.println();
		
		//Start of Game
		do
		{
			//Pile variables
			int pile1 = pileNums();
			int pile2 = pileNums();
			int pile3 = pileNums();
			int pile4 = pileNums();
			
			//Other Variables
			int pileChoice = (0);			//The pile that is chosen by the player
			int sticksChoice = (0);			//The amount of sticks chosen by the player
			int rounds = (0);				//Counts the amount of rounds
			int errorCheckPiles = (0);		//Error check for pile entered by player
			int errorCheckSticks = (0);		//Error check for aapropriate sticks entered by player
			int errorPileQuantity = (0);	//Error if pile is empty
			int gameEndVariable = (0);		//if this is one that means the game will end
			
			System.out.println("Lets Begin, Here are the piles");
			do
			{		
				rounds++;					//counts the rounds
				
				//First players Move
				if (pile1 > 0 || pile2 > 0 || pile3 > 0 || pile4 > 0)
				{
					do
					{
						System.out.println("          " + "Round " + rounds);	//Prints out current round
						
						//FIRST PLAYERS MOVE
						
						//Printing Out Piles
						System.out.print("1:   ");			//Pile A
						for (int i = 0; i < pile1; i++)
						{
							System.out.print("|");
						}
							System.out.println("");
						System.out.print("2:   ");			//Pile B
						for (int i = 0; i < pile2; i++)
						{
							System.out.print("|");
						}
							System.out.println("");
						System.out.print("3:   ");			//Pile C
						for (int i = 0; i < pile3; i++)
						{
							System.out.print("|");
						}
							System.out.println("");			//Pile D
						System.out.print("4:   ");
						for (int i = 0; i < pile4; i++)
						{
							System.out.print("|");
						}
									
						System.out.println();				//blank line

						//Asking the user the game questions
						System.out.println(playerOne + " chose a pile: ");
						pileChoice = in.nextInt();
						System.out.println("How many sticks do you want to remove");
						sticksChoice = in.nextInt();
						if (pileChoice > 4 || pileChoice < 1 )	//error check for their pile choice
						{
							System.out.println(); //blank
							System.out.println("--------------------------------------------------------------"); //border to show error
							System.out.println("ERROR");
							System.out.println("Oops looks like you have entered an invalid pile");
							System.out.println("Please try again");
							System.out.println(); 							//blank line
							errorCheckPiles = 1;							//this variable to set the errorCheck to true
						}
						else if (sticksChoice > 3 || sticksChoice < 1)		//error check for their sticks
						{
							System.out.println(); 							//blank line
							System.out.println("--------------------------------------------------------------"); //border to show error
							System.out.println("Oops looks like you have entered an invalid amount of sticks");
							System.out.println("Please try again");
							System.out.println();							//blank line
							errorCheckSticks = 1;							//this variable to set the errorCheck to true
						}
						else 
						{
							errorCheckPiles = 0;							//this variable is to set the errorCheck to false
							errorCheckSticks = 0;							//this variable is to set the errorCheck to false
							
							//Calculations for piles and sticks
							if (pileChoice == 1 && pile1 > 0) 				//determine which pile and error check for valid pile
							{
								pile1 = (pile1 - sticksChoice);
								errorPileQuantity = 0;						//this is to set the errorCheck to false
							}
							else if (pileChoice == 2 && pile2 > 0) 
							{
								pile2 = (pile2 - sticksChoice);
								errorPileQuantity = 0;
							}
							else if (pileChoice == 3 && pile3 > 0) 
							{
								pile3 = (pile3 - sticksChoice);
								errorPileQuantity = 0;
							}
							else if (pileChoice == 4 && pile4 > 0) 				
							{
								pile4 = (pile4 - sticksChoice);
								errorPileQuantity = 0;
							}
							else 
							{
								errorPileQuantity = 1;						//this sets the errorCheck to true
								System.out.println("--------------------------------------------------------------"); //border to show error
								System.out.println("ERROR");
								System.out.println();						//blanks
								System.out.println();							
								System.out.println("OOOPS, Sorry this pile is empty, please try again");
							}	
						}
					}
					while (errorCheckPiles == 1 || errorCheckSticks == 1 || errorPileQuantity == 1);	//checks and repeats if the errorCheck is true
				}
				//sticks have ran out command						
				else
				{
					System.out.println("CONGRATULATIONS " + playerOne + "!! you have taken the victory");	//victory print for player 1
					System.out.println(playerTwo + " better luck next time");
					gameEndVariable = 1;																	//makes the game end to true
				}
				
				System.out.println("--------------------------------------------------------------"); 
				System.out.println(); 								//blank
				System.out.println(); 								//blank
						
				//SECOND PLAYERS MOVE
				//ALL code here is the same as first player, some differences will be defined
				
				//Printing Out Piles
				if (gameEndVariable == 1)            				//if this is true then game will end
				{
				}
				else if (pile1 > 0 || pile2 > 0 || pile3 > 0 || pile4 > 0)
				{
					do
					{
						System.out.println("          " + "Round " + rounds); 
						//FIRST MOVE
						System.out.print("1:   ");
						for (int i = 0; i < pile1; i++)
						{
							System.out.print("|");
						}
							System.out.println("");
						//Pile B
						System.out.print("2:   ");
						for (int i = 0; i < pile2; i++)
						{
							System.out.print("|");
						}
							System.out.println("");
						//Pile C
						System.out.print("3:   ");
						for (int i = 0; i < pile3; i++)
						{
							System.out.print("|");
						}
						//Pile D
							System.out.println("");
						System.out.print("4:   ");
						for (int i = 0; i < pile4; i++)
						{
							System.out.print("|");
						}
					
						//Blank Line				
						System.out.println();

						//Pile error check and question
						System.out.println(playerTwo + " chose a pile: ");
						pileChoice = in.nextInt();
						System.out.println("How many sticks do you want to remove");
						sticksChoice = in.nextInt();
						if (pileChoice > 4 || pileChoice < 1 )
						{
							System.out.println(); //blank
							System.out.println("--------------------------------------------------------------"); //border
							System.out.println("ERROR");
							System.out.println("Oops looks like you have entered an invalid pile");
							System.out.println("Please try again");
						System.out.println(); //blank
							errorCheckPiles = 1;
						}
						else if (sticksChoice > 3 || sticksChoice < 1)
						{
						System.out.println(); //blank
							System.out.println("--------------------------------------------------------------"); //border
							System.out.println("ERROR");
							System.out.println("Oops looks like you have entered an invalid amount of sticks");
							System.out.println("Please try again");
						System.out.println(); //blank
							errorCheckSticks = 1;
						}
						else 
						{
							errorCheckPiles = 0;
							errorCheckSticks = 0;
							
							//Calculations for piles and sticks
							if (pileChoice == 1 && pile1 > 0) 
							{
								pile1 = (pile1 - sticksChoice);
								errorPileQuantity = 0;
							}
							else if (pileChoice == 2 && pile2 > 0) 
							{
								pile2 = (pile2 - sticksChoice);
								errorPileQuantity = 0;
							}
							else if (pileChoice == 3 && pile3 > 0) 
							{
								pile3 = (pile3 - sticksChoice);
								errorPileQuantity = 0;
							}
							else if (pileChoice == 4 && pile4 > 0) 
							{
								pile4 = (pile4 - sticksChoice);
								errorPileQuantity = 0;
							}
							else 
							{
								errorPileQuantity = 1;
								System.out.println("--------------------------------------------------------------"); 
								System.out.println("ERROR");
								System.out.println();	
								System.out.println();	
								System.out.println("OOPS, Sorry this pile is empty, please try again");
							}
						}
					}
					while (errorCheckPiles == 1 || errorCheckSticks == 1 || errorPileQuantity == 1);
					
					System.out.println(); 
					System.out.println(); 
				}
				//sticks have ran out command						
				else
				{
					System.out.println("CONGRATULATIONS " + playerTwo + "!! you have taken the victory");	//victory print for player 2
					System.out.println(playerOne + " better luck next time");
					gameEndVariable = 1;	
				}
				
			}
			while (gameEndVariable == 0);									
			//END OF GAME 
			
			System.out.println();
			System.out.println();
			System.out.println("Would you like to play another Game of Nim?");		//code to ask the user if they want to play another game or not						
			System.out.println("y or n");
			restartAnswer = in.next().charAt(0);	
		}
		while ('y' == restartAnswer);												//if answer is y, it will restart, if n, it will stop
		System.out.println("Press any button to exit");
	}
}

	



	



			
			

