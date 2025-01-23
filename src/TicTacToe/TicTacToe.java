package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	Scanner scanner = new Scanner(System.in);
	
	String[][] gameMarkers = {
			{" ", " ", " "},
			{" ", " ", " "},
			{" ", " ", " "}
	};
	
	
	int turn = 0;
	int rowNumber;
	int columnNumber;
	char markSelected;
	String player = "X";
		
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe\n");
	}
	
	public void displayGrid() {
		
		String border = "+---+---+---+";
	    System.out.println(border);

	    
	    for (int i = 0; i < gameMarkers.length; i++) {
	        String row = "| ";
	        
	        for (int j = 0; j < gameMarkers[i].length; j++) {
	            row += gameMarkers[i][j];
	            if (j < gameMarkers[i].length - 1) {
	                row += " | ";
	            }
	        }
	        row += " |";
	        System.out.println(row);
	        System.out.println(border);
	    }
		System.out.println();
	}
	
	
	public void takeTurn() {			
		
		while(true) {
			
			System.out.print(player + "'s turn");
			System.out.print("Pick a row (1, 2, 3): ");				
			rowNumber = scanner.nextInt() - 1;
			
			System.out.print("Pick a column (1, 2, 3): ");
			columnNumber = scanner.nextInt() - 1;
			
			if (gameMarkers[rowNumber][columnNumber]!= " ") {
				System.out.println("This space has already been taken. Please choose another.");
			} 
			else {
				
				gameMarkers[rowNumber][columnNumber] = player;
			}
			break;
		}
		turn++;
		System.out.println();
		displayGrid();
				
	}
	
	public boolean checkForWinner() {
		
	    for (int i = 0; i < gameMarkers.length; i++) {
	        if (gameMarkers[i][0].equals(player) &&
	            gameMarkers[i][1].equals(player) &&
	            gameMarkers[i][2].equals(player)) {
	            return true;
	        }
	    }

	    for (int i = 0; i < gameMarkers.length; i++) {
	        if (gameMarkers[0][i].equals(player) &&
	            gameMarkers[1][i].equals(player) &&
	            gameMarkers[2][i].equals(player)) {
	            return true;
	        }
	    }

	    if (gameMarkers[0][0].equals(player) &&
	        gameMarkers[1][1].equals(player) &&
	        gameMarkers[2][2].equals(player)) {
	        return true;
	    }

	    if (gameMarkers[0][2].equals(player) &&
	        gameMarkers[1][1].equals(player) &&
	        gameMarkers[2][0].equals(player)) {
	        return true; 
	    }

	    return false;
		
	}
	
	public void startGame() {
		
		
		while (true){
			
			takeTurn();
			if(checkForWinner()) {
				
				System.out.println("Player " + player + " wins!");
				break;
			}
			if(turn == 9) {
				System.out.println("This game has ended in a draw.");
				break;
			}
			if (player.equals("X")){
				player = "O";	
			}
			else {
				player = "X";
			}
		}
		scanner.close();
	}
}
