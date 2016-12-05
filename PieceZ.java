/**
 * PieceZ class represents the Z shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceZ extends TetrisPiece{
	
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceZ () {
		filledSquares = new boolean [][][] {
			{	
				{true,  true, false, false},
				{false, true, true, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{false, true, false, false},
				{true,  true, false, false},
				{true, false, false, false},
				{false, false,  false, false}
			},
			{	
				{true, true, false, false},
				{false, true, true, false},
				{false, false, false, false},
				{false, false,  false, false}
			},
			{	
				{false,  true, true, false},
				{true,  true, false, false},
				{false, false, false, false},
				{false, false,  false, false}
			}
			
		};
		
	}

}
