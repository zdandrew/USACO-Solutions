

public class Chess {

	private int count;
	public static void main(String[] args) {
		Chess object = new Chess();
		int[][] board = { {0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0} };
		object.recursive(board, 0);
		//object.printSolution(board);
		System.out.println("There are " + object.count + " combos.");
	}	
	
		
	
	public boolean recursive(int board[][], int column) {
		if (column == 8) {
			printSolution(board);
			return false;
		}
		for (int i = 0; i < 8; i++) {
			
			if (isSafe(board, i, column) == true) {
				//printSolution(board);
				board[i][column] = 1;
				
				
				if (recursive(board, column + 1) == true) {
					
					
					return true;
					
				}
				
			board[i][column] = 0;
			}
		
		}
	return false;
	}
	
	public boolean isSafe(int board[][], int row, int column) {
		
		int i, j;
		
		for (i = 0; i < column; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}	
		}
		
		for (i = row, j = column; i < 8 && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}	
		}
		return true;
	}
	public void printSolution(int board[][]) 
    { 
        count = count +1;
		for (int i = 0; i < 8; i++) 
        { 
            for (int j = 0; j < 8; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
            
        } 
        System.out.println();
    }
}

