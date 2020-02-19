public class Minesweeper {
	public static void main(String [] args) {
		int [][] board = new int[10][10];
		for(int i = 0; i < 10; i++) {
			int x = (int)(Math.random() * 8) + 1;
			int y = (int)(Math.random() * 8) + 1;
			board[x][y] = -1;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(board[i][j] != -1){
					board[i][j] = adjacent(i, j, board);
				}
			}
		}
		printArr(board);
		
	}
	public static int adjacent(int x, int y, int[][] board) {
		int count = 0;
		try {
			int left = board[x][y-1];
			if(left == -1) 
				count++;
		}
		catch(Exception e){}
		
		try {
			int right = board[x][y+1];
			if(right == -1) 
				count++;
		}
		catch(Exception e) {}
		
		try {
			int up = board[x - 1][y];
			if(up == -1) {
				count++;
			}
		}
		catch(Exception e) {}
		
		try {
			int down = board[x + 1][y];
			if(down == -1)
				count++;
		}
		catch(Exception e) {}
		
		try {
			int upL = board[x - 1][y - 1];
			if(upL == -1) 
				count++;
		}
		catch(Exception e) {}
		
		try {
			int upR = board[x - 1][y + 1];
			if(upR == -1)
				count++;
		}
		catch(Exception e) {}
		
		try {
			int downL = board[x + 1][y - 1];
			if(downL == -1)
				count++;
		} 
		catch(Exception e) {}
		
		try {
			int downR = board[x + 1][y + 1];
			if(downR == -1)
				count++;
		}
		catch(Exception e) {}
		return count;
	}
	public static void printArr(int[][] array) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
