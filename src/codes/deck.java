package codes;

import java.util.Scanner;

public class deck 
{
	static final int deckSIZE = 52;
	static int[] number = new int[deckSIZE];
	static char[] suit = new char[deckSIZE];
	
	static final int handSIZE = 5;
	static int[] pNumber = new int[handSIZE];
	static char[] pSuit = new char[handSIZE];
	static int[] cNumber = new int[handSIZE];
	static char[] cSuit = new char[handSIZE];
	
	static int counter = 0;
	static int pCounter = 0;
	static int cCounter = 0;
	
	static int playerChoice = 0;
	static int playerSum = 0;
	static int computerSum = 0;
	static int computerAceCounter = 0;
	
	static int endGame = 0;	
	
	public static void numberPopulate ()	//Populates the number array
	{
		for (int x = 0; x < deckSIZE; x++)
		{
			number[x] = x + 1;
			
			if (number[x] < 27 && number[x] > 13)	//minus 13 if the number is greater than 13 but less than 27
				number[x] = number[x] - 13;
			
			if (number[x] < 40 && number[x] > 26)	//minus 26 if the number is greater than 26 but less than 40
				number[x] = number[x] - 26;
			
			if (number[x] < 53 && number[x] > 39)	//minus 39 if the number is greater than 39 but less than 53
				number[x] = number[x] - 39;
				
		}
	}
	
	public static void suitPopulate ()		//Populates the char array with the suits with 4 different loops
	{
		for (int x = 0; x < 13; x++)		//populates the first 13 elements as S for spades
		{
			suit[x] = 'S';
		}
		
		for (int x = 13; x < 26; x++)		//populates the next 13 elements as H for hearts
		{
			suit[x] = 'H';
		}

		for (int x = 26; x < 39; x++)		//populates the next 13 elements as C for clover
		{
			suit[x] = 'C';
		}

		for (int x = 39; x < 52; x++)		//populates the next 13 elements as D for diamond
		{
			suit[x] = 'D';
		}		
	}
	
	public static void display ()			//Displays the the deck array
	{
		for (int x = 0; x < deckSIZE; x++)
		{
			if (number[x] == 1)				//changes all the 1's into A's
			{
				System.out.print("A  ");	
				continue;
			}
			if (number[x] == 11)			//changes all the 11's into J's
			{
				System.out.print("J  ");	
				continue;
			}
			if (number[x] == 12)			//changes all the 12's into Q's
			{
				System.out.print("Q  ");		
				continue;
			}

			if (number[x] == 13)			//changes all the 13's into K's
			{
				System.out.print("K  ");
				continue;
			}
	
			if (number[x] < 10)				//spaces out the numbers to make it look neat
				System.out.print(number[x] + "  ");
			else
				System.out.print(number[x] + " ");
		}
		
		System.out.println();
		
		for (int x = 0; x < deckSIZE; x++)	//prints out the suits
			System.out.print(suit[x] + "  ");
	}
	
	public static void shuffle ()			//Shuffles the arrays
	{
		for (int z = 0; z < deckSIZE; z++)		//loops 52 times
		{
			int y = (int)(Math.random()*deckSIZE); //randomly generates a number to shuffle with
			int x = (int)(Math.random()*deckSIZE);
			
			if (y == x)			//if y and x happen to be the same number, x is turned into another random number
				x = (int)(Math.random()*deckSIZE);
				
			int numberholder = number[y];	//places the first random number into a placeholder
			number[y] = number[x];			//a second random number is put into the place of the first random number
			number[x] = numberholder;		//the number in the placeholder gets put back into the array into the spot of the second random number
			
			char suitholder = suit[y];		//places the first random suit into a placeholder
			suit[y] = suit[x];				//a second random suit is put into the place of the first random suit
			suit[x] = suitholder;			//the suit in the placeholder gets put back into the array into the spot of the second random suit
			
		}		
	}
	
	public static void handPopulate () 		//Populates the player and computer hands
	{
		pCounter = 0;
		cCounter = 0;
		counter = 0;
		
		pNumber[pCounter] = number[counter];	//first number in the number array gets put into the player number array
		pSuit[pCounter] = suit[counter];		//first suit in the suit array gets put into the player suit array
		counter++;								//moves to the second spot in the deck arrays
		pCounter++;								//moves to the second spot in the player arrays
		
		cNumber[cCounter] = number[counter];	//second number in the number array gets put into the computer number array
		cSuit[cCounter] = suit[counter];		//second suit in the suit array gets put into the computer suit array
		counter++;								//moves to the third spot in the deck arrays
		cCounter++;								//moves to the second spot in the computer arrays
		
		pNumber[pCounter] = number[counter];	//third number in the number array gets put into the player number array
		pSuit[pCounter] = suit[counter];		//third suit in the suit array gets put into the player suit array
		counter++;								//moves to the fourth spot in the deck arrays
		pCounter++;								//moves to the third spot in the player arrays
		
		cNumber[cCounter] = number[counter];	//fourth number in the number array gets put into the computer number array
		cSuit[cCounter] = suit[counter];		//fourth suit in the suit array gets put into the computer suit array
		counter++;								//moves to the fifth spot in the deck arrays
		cCounter++;								//moves to the third spot in the computer arrays
	}
	
	public static void playerDisplay ()		//Displays the player's hand
	{
		for (int x = 0; x < pCounter; x++)
		{
			if (pNumber[x] == 1)
			{
				System.out.print("A  ");		//changes all the 1's into A's
				continue;
			}
			
			if (pNumber[x] == 11)
			{
				System.out.print("J  ");		//changes all the 11's into J's
				continue;
			}
			
			if (pNumber[x] == 12)
			{
				System.out.print("Q  ");		//changes all the 12's into Q's
				continue;
			}

			if (pNumber[x] == 13)
			{
				System.out.print("K  ");		//changes all the 13's into K's
				continue;
			}
	
			if (pNumber[x] < 10)				//if the number is less than one, there's another space to make it look neat
				System.out.print(pNumber[x] + "  ");
			else
				System.out.print(pNumber[x] + " ");
		}
		
		System.out.println();
		
		for (int x = 0; x < pCounter; x++)
			System.out.print(pSuit[x] + "  ");	
	}

	public static void computerHiddenDisplay ()	//Displays the computer's hand with the second card hidden
	{
		for (int x = 0; x < 1; x++)	
		{
			if (cNumber[x] == 1)
			{
				System.out.print("A  ");	//changes all the 1's into A's
				continue;
			}
			if (cNumber[x] == 11)
			{
				System.out.print("J  ");	//changes all the 11's into J's
				continue;
			}
			if (cNumber[x] == 12)
			{
				System.out.print("Q  ");	//changes all the 12's into Q's
				continue;
			}

			if (cNumber[x] == 13)
			{
				System.out.print("K  ");	//changes all the 13's into K's
				continue;
			}
	
			if (cNumber[x] < 10)			//if the number is less than one, there's another space to make it look neat
				System.out.print(cNumber[x] + "  ");
			else
				System.out.print(cNumber[x] + " ");
		}
		
		for (int x = 0; x < 1; x++)		//prints out a symbol to hide the 2nd number of the computer's hand
			System.out.print("#");

		System.out.println();
		
		for (int x = 0; x < 1; x++)		//prints out the suit of the first hand
			System.out.print(cSuit[x] + "  ");
		
		for (int x = 0; x < 1; x++)		//prints out a symbol to hide the 2nd number of the computer's hand
			System.out.print("#");
	}
	
	public static void computerNormalDisplay ()	//Displays the computer's hand with all cards revealed
	{
		for (int x = 0; x < cCounter; x++)
		{
			if (cNumber[x] == 1)
			{
				System.out.print("A  ");		//changes all the 1's into A's
				continue;
			}
			
			if (cNumber[x] == 11)
			{
				System.out.print("J  ");		//changes all the 11's into J's
				continue;
			}
			
			if (cNumber[x] == 12)
			{
				System.out.print("Q  ");		//changes all the 12's into Q's
				continue;
			}

			if (cNumber[x] == 13)
			{
				System.out.print("K  ");		//changes all the 13's into K's
				continue;
			}
	
			if (cNumber[x] < 10)				//if the number is less than one, there's another space to make it look neat
				System.out.print(cNumber[x] + "  ");
			else
				System.out.print(cNumber[x] + " ");
		}
		
		System.out.println();
		
		for (int x = 0; x < cCounter; x++)
			System.out.print(cSuit[x] + "  ");
	}
	
	public static void addingValue ()		//Adds the value of the cards
	{
		int playerAceCounter = 0;
		playerSum = 0;
		computerSum = 0;
		
		for (int x = 0; x < pCounter; x++)
		{
			if (pNumber[x] > 10)			//if the number is greater than 10, it only adds 10 because of face cards
				playerSum = playerSum + 10;
			else if (pNumber[x] == 1)		//if the number is 1, it adds 11 because it's an ace
			{
				playerSum = playerSum + 11;
				playerAceCounter++;
			}
			else							//otherwise add the direct number to the sum
				playerSum = playerSum + pNumber[x];
			
			if (cNumber[x] > 10)			//same thing for the computer hand
				computerSum = computerSum + 10;
			else if (cNumber[x] == 1)
			{
				computerSum = computerSum + 11;
				computerAceCounter++;
			}
			else
				computerSum = computerSum + cNumber[x];
		}
		
		while (playerSum > 21 && playerAceCounter > 0)		//if the sum is greater than 21 and there's more than one ace, minus 10
		{
			playerSum = playerSum - 10;
			playerAceCounter--;
		}
		
		while (computerSum > 21 && computerAceCounter > 0)	//same thing for the computer hand
		{
			computerSum = computerSum - 10;
			computerAceCounter--;
		}		
		
		System.out.println();
		
		if (playerSum == 21)	//if the sum is equal to 21, the player wins
		{
			System.out.println("You win!!");
			playAgain();
		}
	}
	
	public static void hitOrStand ()				//hits or stand depending on the wish of the player
	{
		Scanner input = new Scanner(System.in);
	
		do
		{
			System.out.println("Your sum is: " + playerSum);	//prints out the sum and asks if the player wants to hit ot stand
			System.out.println();
			System.out.println("Would you like to hit or stand?");
			System.out.println("Yes(1) or No(0)");
			playerChoice = input.nextInt();
			System.out.println();
			
			if (playerChoice == 1) //if the player wants to hit, a card is added
			{
				pNumber[pCounter] = number[counter];
				pSuit[pCounter] = suit[counter];
				counter++;
				pCounter++;
				System.out.println();
			}
		
			playerDisplay();
			addingValue();
			playerWinCondition();
			
			if (playerChoice == 0)
			{
				System.out.println("Your sum is: " + playerSum);
				computerHandHitOrStand();
			}		
		}while(playerChoice == 1);		//if the choice for hitting or standing is 0, end the method
				
		input.close();
	}
	
	public static void computerHandHitOrStand ()	//hitting or standing for the computer's hand
	{	
		do
		{
			cNumber[cCounter] = number[counter];	//if the computer's hand is less than 16, add until the sum reaches 17 or higher
			cSuit[cCounter] = suit[counter];
			counter++;
			cCounter++;
			System.out.println();
			
			while (computerSum > 21 && computerAceCounter > 0)	//same thing for the computer hand
			{
				computerSum = computerSum - 10;
				computerAceCounter--;
			}		
		}while (computerSum <= 16);
		
		computerNormalDisplay();
		addingValue();
		System.out.println("The dealer's sum is: " + computerSum);
		
		//calculates the win conditions 
		if (playerSum > computerSum || computerSum > 21) //if the player has a higher sum than the computer
		{												 //or the computer busts, player wins
			System.out.println("You win!");
			playAgain();
		}
		else if (playerSum == computerSum)				//if both sums equal, it's a tie
		{
			System.out.println("Tie!");
			playAgain();
		}
		else if (computerSum < 21 && cCounter > 4)		//if the computer sum is less than 21 and have more than 4 cards, computer wins
		{
			System.out.println("You lose!");
			playAgain();
		}
		else											//in any other situation, player loses
		{
			System.out.println("You lose!");
			playAgain();
		}
	}
	
	public static void playerWinCondition()			//calculates the player's win conditions
	{
		if (playerSum > 21)							//if the player busts, player loses
		{
			System.out.println("Your sum is: " + playerSum);
			System.out.println("You lose!");
			playAgain();
		}
		else if (playerSum == 21)					//if the sum is equal to 21, player wins
		{
			System.out.println("You win!!");
			playAgain();
		}
		else if (playerSum < 21 && pCounter > 4)	//if the player sum is less than 21 and have more than 4 cards, player wins
		{
			System.out.println("You win!!");
			System.out.println("You have 5 cards and a sum less than 21!");
			playAgain();
		}
	}
	
	public static void playAgain ()					//algorithm for setting to play again after a win/lose condition
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Would you like to play again?");		//asks if player wants to play again
		System.out.println("Yes(1) or No(0)");
		endGame = input.nextInt();						//records the input with a 1 for yes or a 0 for no
		System.out.println();
		
		playerSum = 0;
	}
	
	public static void main(String[] args) 
	{		
			numberPopulate();		//populates numbers
			
			suitPopulate();			//populates suits
			
			display();				//displays the card deck
			
			System.out.println();
			System.out.println();
			
			shuffle();				//shuffles the deck
	
			display();				//displays the newly shuffled deck
			
			handPopulate();			//populates the player and computer hands
			
			System.out.println();
			System.out.println();
			
		do					//as long as the player wants to keep playing, this will run forever
		{		
			computerHiddenDisplay();		//shows the computer's hand with one card shown and one hidden
			
			System.out.println();
			System.out.println();
			
			playerDisplay();				//displays the player's hand
			
			addingValue();					//adds the overall value of both hands separately
		
			while (playerSum < 21)			//as long as the sum of the player is less than 21, it will ask to hit or stand
				hitOrStand();
			
			if (playerChoice == 0 && playerSum < 21)		//if the player wants to stand and they still haven't won, show the player sum again and let the computer do the hit or stand process
			{
				System.out.println();
				System.out.println("Your sum is:" + playerSum);
				computerHandHitOrStand();				
			}
		}while (endGame != 0);
		
		System.out.println("Thanks for playing!");
	}
}
