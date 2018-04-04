import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
	
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char[][] board;
	HashSet<String> word = new HashSet<String>();
	
	
	public Matrix() throws IOException{
	word = dictionary();
	
	}
	
	
	public char rando()
	{
		Random rd = new Random();
		char letter = alphabet.charAt(rd.nextInt(alphabet.length()));
		return letter;
		
	}
	
	public char[][] print()
	{
		
		board = new char[8][8];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++)
			{
				board[i][j] = rando();
			}
		}
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j] + " ");
			}
		System.out.println();}
		return board;
		
	}
	
	public HashSet<String> dictionary() throws IOException
	{
		
		Scanner s = new Scanner(new File("dictionary.txt"));
		
		
		while(s.hasNext())
		{
			word.add(s.next().toUpperCase());
			
		}
		s.close();
		return word;
	}
	
	
	
	public boolean check(String input) throws IOException
	{
		input = input.toUpperCase();
		return word.contains(input);
	}
	
	public boolean findPosition(char bog[][], String input)
	{
		boolean used[][] = new boolean[8][8];
		
		input = input.toUpperCase();
		int index = 0;
		
		for(int i = 0; i < bog.length; i++){
			for(int j = 0; j < bog[i].length; j++){
				if ((bog[i][j] == input.charAt(0)) &&(findWord(used,bog, input, index, i, j))){
					return true;
				}
			}
		}
		return false;
		
		
	}
	
	public boolean findWord(boolean used[][],char bog[][], String input, int index, int i, int j)
	{
		used[i][j] = true;
		
		if(index + 1 >= input.length())
		{
			
			return true;
		}
		for (int row = i-1; row <= i+1 && row < 8; row ++)
			for (int col = j-1; col<= j+1 && col < 8; col++)
				if(row>=0 && col >=0 &&(bog[row][col] == input.charAt(index+1)) && !used[row][col]){
					
					if(findWord(used, bog, input, index+1, row, col)){
						
						return true;
					};
				}
		
		
		used[i][j] = false;
		return false;
		
		
		
		//if you search and don't find currentletter input.charAt(index), then impossible.. return false.
		
		
	}
	
	/*8public void findWords(char bog[][], boolean used[][], int i, int j, String input) throws IOException
	{
		used[i][j] = true;
		input = input + bog[i][j];
		
		
		if (check(input))
			System.out.println(input);
		
		for (int row = i-1; row <= i+1 && row < 8; row ++)
			for (int col = j-1; col<= j+1 && col < 8; col++)
				if(row>=0 && col >=0 && !used[row][col])
					findWords(bog, used, row, col, input);
		
		input = input.substring(0, input.length() - 1);
		used[i][j] = false;
		
	}
	
	public void printAll(char bog[][]) throws IOException
	{
		
		boolean used[][] = new boolean[bog.length][bog[0].length];
		
		String input = ""; 
		
		for (int i =0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				findWords(bog, used, i, j, input);
				
	}*/
	
}
