/**
 * PieceI class represents the I shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceI extends TetrisPiece{
	
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceI () {
		filledSquares = new boolean [][][] {
			{	
				{true,  true, true, true},
				{false, false, false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{true, false,  false, false}
			},
			{	
				{true,  true, true, true},
				{false, false, false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true, false, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{true, false,  false, false}
			}
			
		};
		
	}

}
