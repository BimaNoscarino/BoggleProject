import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Boggle {
	
	
	
	public static void main (String[] args) throws IOException
	{
		
		
		System.out.println("Welcome to Boggle. Now displaying game board.\n");
		boolean exit = false; 
		boolean exit2 = false;
		Matrix bog = new Matrix();
		char[][] board = bog.print(); 
		ArrayList<String> confirmed = new ArrayList<String>(); 
		
		
	
		
		while(!exit)
		{
			System.out.println("\nEnter corresponding number for game options\n");
			System.out.println("1. Play");
			System.out.println("2. Reset board");
			System.out.println("3. Display verified words");
			System.out.println("4. Exit\n");
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();
			
			if(input.equals("1"))
			{
				while(!exit2)
				{
				
				System.out.println("Enter word:\n Press 0 to exit to game options");
				String input2 = in.nextLine();
				
				if(input2.equals("0")){
					break;
				}
				
				boolean onBoard = bog.findPosition(board, input2);
				if(onBoard)
					System.out.println("Word is on board.\n");
				boolean inDict = bog.check(input2);
				if (inDict)
					System.out.println("Word is in dictionary.\n");
				if(onBoard && inDict)
				{
					System.out.println("Valid word entered!\n");
					confirmed.add(input2);
				}
				else
					System.out.println("Word is invalid, please try another:\n");
				
				}
				
			}
			else if(input.equals("2"))
			{
				Boggle.main(args);
				
			}
			else if(input.equals("3"))
			{
				System.out.println(confirmed);
				
			}
			else if (input.equals("4"))
			{
				exit = true;
			}
			else
			{
				System.out.println("Invalid index, try again");
			}
		}
		System.out.println("Exiting program.");
		
		
	}

}
