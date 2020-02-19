
public class Cell {
	
// get cell position
private final int xPosition;
private final int yPosition;

// cell properties
	
private final boolean isMine;
private boolean isFlagged;
private boolean isShown;

private String sym;
private String value;

// get cell surroundings


public Cell(int x, int y, boolean isMine, Cell[][] board) {
	
	this.isMine = isMine;
	this.isFlagged = false;
	this.isShown = false;
	
	
	this.xPosition = x;
	this.yPosition = y;
	sym = "*";
	
	if (this.isMine) {
		value = "#";
	}
	
}
	public boolean isMine() {
		return isMine;
	}
	
	public int getX() {
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}
	
	public String getSym() {
		return sym;
	}
	public void show() {
		sym = value;
		isShown = true;
	}
	
	public boolean isShown () {
		return isShown;
	}
	
	public boolean hasValue() {
		
		if (isMine == true) return false;
		
		return Integer.parseInt(value) > 0;
	}
	


	public String getValue() {
		return value;
	}
	
	// Grab surrounding cells from the getSurrounding class 
	// Check for the number of mines in the array list
	
	public boolean isFlagged() {
		return isFlagged;
	}
	@Override
	public String toString() {
		return "X: " + xPosition + " Y: " + yPosition + " Value:" + value;
		
	}
		
}