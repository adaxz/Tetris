/**
 * PieceO class represents the O shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceO extends TetrisPiece{
	
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceO () {
		filledSquares = new boolean [][][] {
			{	
				{true,  true,  false, false},
				{true,  true,  false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true,  true,  false, false},
				{true,  true,  false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true,  true,  false, false},
				{true,  true,  false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true,  true,  false, false},
				{true,  true,  false, false},
				{false, false, false, false},
				{false, false, false, false}
			}
		};
		
	}
}