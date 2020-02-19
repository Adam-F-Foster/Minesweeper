import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

public class DisplayController {
	@FXML
	private Button b03;
	@FXML
	private Button b01;
	@FXML
	private Button b02;
	@FXML
	private Button b09;
	@FXML
	private Button b08;
	@FXML
	private Button b04;
	@FXML
	private Button b06;
	@FXML
	private Button b07;
	@FXML
	private Button b05;
	@FXML
	private Button b00;
	@FXML
	private Button b17;
	@FXML
	private Button b10;
	@FXML
	private Button b18;
	@FXML
	private Button b15;
	@FXML
	private Button b12;
	@FXML
	private Button b19;
	@FXML
	private Button b14;
	@FXML
	private Button b16;
	@FXML
	private Button b11;
	@FXML
	private Button b13;
	@FXML
	private Button b23;
	@FXML
	private Button b29;
	@FXML
	private Button b21;
	@FXML
	private Button b26;
	@FXML
	private Button b24;
	@FXML
	private Button b22;
	@FXML
	private Button b25;
	@FXML
	private Button b20;
	@FXML
	private Button b28;
	@FXML
	private Button b27;
	@FXML
	private Button b37;
	@FXML
	private Button b30;
	@FXML
	private Button b34;
	@FXML
	private Button b35;
	@FXML
	private Button b38;
	@FXML
	private Button b36;
	@FXML
	private Button b31;
	@FXML
	private Button b33;
	@FXML
	private Button b39;
	@FXML
	private Button b32;
	@FXML
	private Button b49;
	@FXML
	private Button b48;
	@FXML
	private Button b40;
	@FXML
	private Button b43;
	@FXML
	private Button b41;
	@FXML
	private Button b47;
	@FXML
	private Button b42;
	@FXML
	private Button b44;
	@FXML
	private Button b45;
	@FXML
	private Button b46;
	@FXML
	private Button b59;
	@FXML
	private Button b53;
	@FXML
	private Button b52;
	@FXML
	private Button b57;
	@FXML
	private Button b50;
	@FXML
	private Button b56;
	@FXML
	private Button b51;
	@FXML
	private Button b55;
	@FXML
	private Button b54;
	@FXML
	private Button b58;
	@FXML
	private Button b64;
	@FXML
	private Button b61;
	@FXML
	private Button b69;
	@FXML
	private Button b68;
	@FXML
	private Button b66;
	@FXML
	private Button b62;
	@FXML
	private Button b67;
	@FXML
	private Button b65;
	@FXML
	private Button b60;
	@FXML
	private Button b63;
	@FXML
	private Button b76;
	@FXML
	private Button b72;
	@FXML
	private Button b75;
	@FXML
	private Button b77;
	@FXML
	private Button b71;
	@FXML
	private Button b74;
	@FXML
	private Button b78;
	@FXML
	private Button b79;
	@FXML
	private Button b73;
	@FXML
	private Button b70;
	@FXML
	private Button b84;
	@FXML
	private Button b80;
	@FXML
	private Button b83;
	@FXML
	private Button b82;
	@FXML
	private Button b81;
	@FXML
	private Button b85;
	@FXML
	private Button b86;
	@FXML
	private Button b88;
	@FXML
	private Button b87;
	@FXML
	private Button b89;
	@FXML
	private Button b94;
	@FXML
	private Button b92;
	@FXML
	private Button b91;
	@FXML
	private Button b97;
	@FXML
	private Button b93;
	@FXML
	private Button b98;
	@FXML
	private Button b96;
	@FXML
	private Button b90;
	@FXML
	private Button b99;
	@FXML
	private Button b95;
	@FXML
	private Button generate;
	@FXML
	private AnchorPane pane;
	
	private int[][]board;

	// Event Listener on Button[#b03].onMouseClicked
	@FXML
	public void click(MouseEvent event) {
		Button button = (Button)event.getSource();
		String id = button.getId();
		int x = Integer.parseInt(id.substring(1, 2));
		int y = Integer.parseInt(id.substring(2));
		if(event.getButton() == MouseButton.SECONDARY) {
			if(button.getText().equals("X"))
				button.setText(" ");
			else
				button.setText("X");
		}
		else {
			if(button.getText().equals(" ")) {
				if(board[x][y] == -1) {
					button.setText("M");
					//board[x][y]
					
					
					generate(event);
				}
				else
					button.setText(board[x][y] + "");
				if(board[x][y] == 0) {
					setSurrounding(x, y);
				}
			}
		}
	}
	public void generate(MouseEvent e) {
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
		this.board = board;
		for(int i = 0; i < pane.getChildren().size(); i++) {
			Button button = (Button)pane.getChildren().get(i);
			button.setText(" ");
		}
	}
	public void setSurrounding(int x, int y) {
		
	}
	public int adjacent(int x, int y, int[][] board) {
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
	class Board{
		Cell[][] board;
		public Board(Cell [][] board) {
			this.board = board;
		}
	}
	class Cell{
		int type;
		boolean click;
		int mines;
		public Cell(int type, boolean click, int mines) {
			this.type = type;
			this.click = click;
			this.mines = mines;
		}
		public void setClick() {
			this.click = true;
		}
	}

}

	