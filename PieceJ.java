/**
 * PieceJ class represents the J shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceJ extends TetrisPiece{
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceJ () {
		filledSquares = new boolean [][][] {
			{	
				{false,  true, false, false},
				{false, true, false, false},
				{true, true, false, false},
				{false, false, false, false}
			},
			{	
				{true, false, false, false},
				{true,  true, true, false},
				{false, false, false, false},
				{false, false,  false, false}
			},
			{	
				{true, true, false, false},
				{true, false, false, false},
				{true, false, false, false},
				{false, false,  false, false}
			},
			{	
				{true,  true, true, false},
				{false,  false, true, false},
				{false, false, false, false},
				{false, false,  false, false}
			}
			
		};
		
	}

}
