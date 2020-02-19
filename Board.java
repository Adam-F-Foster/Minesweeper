import java.util.ArrayList;
import java.util.Random;

public class Board {

	
/// x and y position - Jared
int mx, my;


// Creating cell - Jared
private Cell[][] myBoard;

// Create list to hold cells  - Jared
private ArrayList<Cell> surroundingCells;


private int xPosition;
private int yPosition;

private boolean isMine;
private boolean isFlagged;
private boolean isShown;

// Using arrays

boolean[][] mined;

int [][] mines;

private String sym;
private String value;


// Handle if the Cell that was clicked was a mine - Jared Miller
boolean[][] revealed; 
public void Cell(int x, int y, boolean isMine, Cell[][] board) {
	
	this.isMine = isMine;
	this.isFlagged = false;
	this.isShown = false;
	
	this.myBoard = board;
	surroundingCells = new ArrayList<>();
	
	this.xPosition = x;
	this.yPosition = y;
	sym = "*";
	
	if (this.isMine) {
		value = "#";
	}
	
}

// Board class to find the array of mines

	public Board() {
		Random choas = new Random();
		
		mx = 10;
		my = 10;
		// find the mine
		for (int x= 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				mined[x][y] = choas.nextFloat() < 0.2;
			}
		}
		
		
		
		
		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++ ) {
				mines[x][y] = 0;
				for (int j = (x-1); j < mx && j <= x + 1; j++) {
					int nx = j;
					int ny = j; 
					if (mined[nx][ny] == true) {
					mines[x][y]++;
				}
					
				}
			}
			}
		}
	
	
/// Set the surrounding cells once mine is revealed
public ArrayList<Cell> getSurrounding() {
		
		if (surroundingCells.isEmpty()) {
			setSurroundingCells();
		}
		return surroundingCells;
	}
	private void setSurroundingCells() {
		for (int i = xPosition - 1; i <= xPosition + 1; i++) {
			for (int j = yPosition - 1; j <= yPosition + 1; j++) {
				
				if (i == xPosition && j == yPosition) {
				} else {
					try {
						surroundingCells.add(myBoard[i][j]);
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
		}
	}

	/// Flagging system 
	public void setFlagged(boolean flagged) {
		isFlagged = flagged;
		
		if (isShown) {
			return;
		} else if (isFlagged) {
			sym = "F";
		} else {
			if (isMine) {
				sym = "#";
			} else if (isShown) {
				sym = value;
			} else {
				sym = "*";
			}
		}
	}


// End the game 

void endGame(int x, int y) {
	reveal(x,y);
	if (mined[x][y]) {
		System.out.print("Game Over");
	}
}

void reveal(int x, int y) {
	if (!revealed[x][y]) {
		revealed[x][y] = true;
		if (mines[x][y] == 0) {
		for (int nx = (x-1); nx < mx && nx <= x + 1; nx++) {
				for (int ny = (y -1); ny < my && ny <= y + 1; y++) {
					reveal(mx, my);
				}
			}
		}
	
}

}
}
