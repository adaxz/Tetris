/**
 * TetrisPiece class is a superclass of 7 different kinds of tetris pieces
 * It maintains 4 rotations (0 degrees, 90 degrees, 180 degrees and 270 degrees), 
 * with each being a 4x4 grid with certain filled squares.
 * @author Xuzhen Xiang
 * @version part2
 *
 */
public class TetrisPiece {
	//3 dimensional array maintaining which squares are filled first dimension is rotation
	//second and third dimensions create 4x4 grid with true values indicating filled squares
	protected boolean [][][] filledSquares;

	//initialize the rotate index as 0
	protected int pieceRotation = 0;

	/**
	 * constructor
	 */
	public TetrisPiece () {


	}
	
	/**
	 * Rotate the piece counter-clockwise by 90 degrees by adding 1 to the rotation index
	 */
	protected void rotateCW() {

		if (pieceRotation < 3){
			pieceRotation = pieceRotation + 1;
		}
		//after the first round of the rotation, set the index as 0
		else {
			pieceRotation = 0;
		}


	}
	
	/**
	 * Rotate the piece clockwise by 90 degrees by subtracting 1 from the rotation index
	 */
	protected void rotateCCW() {
		if (pieceRotation > 0){
			pieceRotation = getPieceRotation() - 1;
		}
		//after the first round of the rotation, set the index as 3
		else {
			pieceRotation = 3;
		}
	}

	/**
	 * Checks if there is a TetrisBlock at the (row, col) position for the rotation rot, 
	 * where rot is 0, 90, 180 or 270 degrees.
	 * @param rot, the rotation index
	 * @param row, row index in the piece matrix
	 * @param col, col index in the piece matrix
	 * @return true, if there is a tetris block at the testing position
	 */
	public boolean isFilled (int rot, int row, int col){
		if (filledSquares[rot][row][col]){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * get the current piece rotation index
	 * @return pieceRotation, rotation index
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}
}
