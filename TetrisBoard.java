/**
 * The TetrisBoard class represents the model: 
 * a board on which Tetris is played; 
 * it maintains the grid (the block matrix) and the current piece.
 * @author Xuzhen Xiang
 * @version Part 3
 *
 */
public class TetrisBoard {
	//variable remembering the grid
	private boolean[][] blockMatrix;
	//variable remembering current tetris piece
	private TetrisPiece currentPiece;
	//int array containing column index and row index for the left top block of the current tetris piece
	private int[] currentPiecePosition;
	//number of rows of the grid
	public static final int NUM_COLS = 10;
	//number of columns of the grid
	public static final int NUM_ROWS = 18;
	//variable remembering number of rows that have been cleared
	private int numRows;
	
	
	
	/**
	 * constructor
	 * set up the board
	 * 
	 */
	public TetrisBoard() {
		//set up the size of the board
		blockMatrix = new boolean [NUM_ROWS][NUM_COLS];
		//initialize the board
		initBoard();
		
		
	}
	
	/**
	 * Initialize the board with a boolean 2D array containing all false values
	 */
	private void initBoard() {
		for (int row = 0; row < NUM_ROWS; row ++){
			for (int col = 0; col < NUM_COLS; col ++){
				blockMatrix [row][col] = false;
			}
		}
	}

	/**
	 * Update the board array to reflect the newly landed piece's filled squares
	 * by setting the value of the block where the piece landed as true
	 */
	public void landPiece() {
		//get the rotation of the current piece
		int rot = currentPiece.getPieceRotation();
		//loop through the piece to find the true value in the piece
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j ++){
				if (currentPiece.isFilled(rot, i, j)){
					//set the value in the block as true
					blockMatrix[currentPiecePosition[0] + i][currentPiecePosition[1] + j] = true;
					
				}
			}

		}


	}
	
	
	/**
	 * get the 2D boolean array representing the current block matrix
	 * @return blockMatrix, the current block matrix
	 */
	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}
	
	/**
	 * check if the piece can be moved down,
	 * if it can, then move the piece down by adding 1 to the row of the current piece position
	 * @return true, if moveDown is valid
	 */
	public boolean moveDown() {
		//check whether the current piece can be move down
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPiecePosition[0] + 1, currentPiecePosition[1])){
			currentPiecePosition = getCurrentPieceGridPostition();
			//change the current position of the piece
			currentPiecePosition[0]  =  currentPiecePosition[0] + 1;
			//return true if the move is valid
			return true;
		}
		else{
			//return false if the move is invalid
			return false;
		}
	}
	
	/**
	 * check if the piece can be moved to the left,
	 * if it can, then move the piece to the left by subtracting 1 from the column of the current piece position
	 * @return true, if moveLeft is valid
	 */
	public boolean moveLeft() {
		//check whether the current piece can be move to the left
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPiecePosition[0], currentPiecePosition[1]-1)){
			currentPiecePosition = getCurrentPieceGridPostition();
			//change the current position of the piece
			currentPiecePosition[1]  =  currentPiecePosition[1] - 1;			
			//return true if the move is valid
			return true;
		}
		return false;
	}

	/**
	 * check if the piece can be moved to the right,
	 * if it can, then move the piece to the right by adding 1 to the column of the current piece position
	 * @return true, if moveRight is valid
	 */
	public boolean moveRight() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPiecePosition[0], currentPiecePosition[1] + 1)){
			currentPiecePosition  = getCurrentPieceGridPostition();
			//change the current position of the piece
			currentPiecePosition[1] =  currentPiecePosition[1] + 1;
			//return true if the move is valid
			return true;
		}
		//return false if the move is invalid
		return false;


	}
	
	/**
	 * rotate the piece clockwise
	 * if rotating the piece will cause the piece to go out of the board, rotate back
	 * @return true, if the rotate is valid
	 */
	public boolean rotateCW() {
		currentPiece.rotateCW();
		//check whether the piece is out of the board
		if (!validMove(currentPiece, currentPiece.getPieceRotation(), currentPiecePosition[0], currentPiecePosition[1])){
			currentPiece.rotateCCW();
			return false;
		}
		
		return true;
	}

	/**
	 * rotate the piece counterclockwise
	 * if rotating the piece will cause the piece to go out of the grid, rotate back
	 * @return true, if the rotate is valid
	 */
	public boolean rotateCCW() {
		currentPiece.rotateCCW();
		//check whether the piece is out of the board
		if (!validMove(currentPiece, currentPiece.getPieceRotation(), currentPiecePosition[0], currentPiecePosition[1])){
			currentPiece.rotateCW();
			return false;
		}
		
		return true;
	}

	/**
	 * Add a new random Tetris piece to the board at grid position (0, 3)
	 */
	public void addNewPiece () {

		//generate a random number between 0 and 7 
		int pieceKind = (int)(Math.random()*7);
		//int pieceKind = 3;
		//add different pieces based on the random number
		if(pieceKind == 0){
			currentPiece = new PieceL();
		}
		else if (pieceKind == 1){
			currentPiece = new PieceZ();
		}
		else if (pieceKind == 2){
			currentPiece = new PieceJ();
		}
		else if (pieceKind == 3){
			currentPiece = new PieceO();
		}
		else if (pieceKind == 4){
			currentPiece = new PieceS();
		}
		else if (pieceKind == 5){
			currentPiece = new PieceI();
		}
		else if (pieceKind == 6){
			currentPiece = new PieceT();
		}
		
		//set the initial position at grid position (0, 3)
		currentPiecePosition = new int [] {0, 3};
	}
	

	/**
	 * Checks if placing the piece at grid position with the rotation would cause an out of bounds condition
	 * @param piece, the current piece
	 * @param rot, the rotation of the current piece
	 * @param gridRow, the anticipated piece grid row position 
	 * @param gridCol, the anticipate piece grid column position
	 * @return true, if placing the piece at grid position with the rotation would cause an out of bounds condition
	 */
	private boolean detectOutBounds(TetrisPiece piece, int rot, int gridRow, int gridCol){
		//loop though the piece
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j++){
				//if the block in the piece is true, check if the position of the block is out of bounds
				if (piece.isFilled(rot, i, j)){
					if (gridCol + j  > NUM_COLS - 1 || gridCol + j < 0 || gridRow + i > NUM_ROWS - 1){
						return true;

					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if placing the piece at grid position with the rotation rot would cause a collision 
	 * @param piece, current piece
	 * @param rot, the rotation of the current piece
	 * @param gridRow, the anticipated piece position 
	 * @param gridCol, the anticipate piece position
	 * @return true, if placing the piece at grid position with the rotation rot would cause a collision
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		//loop though the piece
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j ++){
				//if the block in the piece is true, check if the grid around the piece is filled with true values
				if (piece.isFilled(rot, i, j)){
					if (blockMatrix[gridRow + i][gridCol + j]||blockMatrix[gridRow][gridCol + j]){
						return true;
					}
				}
			}
		}
		return false;
	}

	
	/**
	 * Checks if placing the piece at grid position  with the rotation rot is a valid move.
	 *  @param piece, current piece
	 * @param rot, the rotation of the current piece
	 * @param gridRow, the anticipated piece position 
	 * @param gridCol, the anticipate piece position
	 * @return true, if placing the piece at grid position will not cause a collision or out of bounds problem
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
		if (!detectOutBounds(piece, rot, gridRow, gridCol) &&
				!detectCollision(piece, rot, gridRow, gridCol)){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check if there is a block in the row and column.
	 * @param row, the row index of the grid
	 * @param col, the col index of the grid
	 * @return true, if there is block in the row and column
	 */
	public boolean hasBlock(int row, int col){
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j ++){
				//row index in the board that is overlapped by the piece
				int rows = currentPiecePosition[0]+i;
				//col index in the board that is overlapped by the piece
				int cols = currentPiecePosition[1]+j;
				//if the grid in the board is overlapped by the piece and the grid is filled with a true value, return true
				if (rows == row && cols == col &&currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)){
					return true;
				}
			}
		}
		return blockMatrix[row][col];

	}
	
	/**
	 * check whether the specific row is filled, 
	 * if it is, remove this row,
	 * up number of cleared rows
	 * @return numRows, the number of cleared rows
	 */
	public int numberOfFormedLines(){
		for (int row = 0; row < NUM_ROWS; row ++){
			if (fullLine(row)){
				removeLine(row);
				numRows ++;
			}
		}
		return numRows;
	}
	
	/**
	 * remove a specific row by assigning the value of row above to the current row
	 * @param row, the row needed to be removed
	 */
	public void removeLine(int row){
		for(int i = row; i >0; i --){
			for(int col = 0; col < NUM_COLS; col++) {
				blockMatrix [i][col] = blockMatrix[i-1][col];

			}
		}
	}

	
	/**
	 * check whether a specific row is filled 
	 * @param row, the row needed to be checked
	 * @return true, if the row is filled
	 */
	private boolean fullLine(int row) {
		for (int col = 0; col < NUM_COLS; col ++){
			if(!blockMatrix[row][col]){
				return false;
			}
		}

		return true;
	}
	
	/**
	 * get the current tetris piece
	 * @return currentPiece, current tetris piece
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}
	
	/**
	 * get the grid position of the current piece
	 * @return
	 */
	public int[] getCurrentPieceGridPostition() {
		return currentPiecePosition;
	}
	
	/**
	 * check whether the player lose the game
	 * if the top row has any grid with a true value, the game end
	 * @return true, if the top row has any grid with a true value
	 */
	public boolean gameEnd() {
		for (int col = 0; col < NUM_COLS; col ++){
			if(blockMatrix[0][col] == true){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * get the number of cleared lines
	 * @return numRows, the number of cleared lines
	 */
	public int getNumRows() {
		return numRows;
	}



}
