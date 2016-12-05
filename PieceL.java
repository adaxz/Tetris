/**
 * PieceL class represents the L shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceL extends TetrisPiece{
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceL () {
		filledSquares = new boolean [][][] {
			{	
				{true,  false, false, false},
				{true,  false, false, false},
				{true,  true,  false, false},
				{false, false, false, false}
			},
			{	
				{true, true, true, false},
				{true, false, false, false},
				{false, false, false, false},
				{false, false,  false, false}
			},
			{	
				{true,  true, false, false},
				{false, true, false, false},
				{false, true, false, false},
				{false, false,  false, false}
			},
			{	
				{false,  false, true, false},
				{true,  true, true, false},
				{false, false, false, false},
				{false, false,  false, false}
			}
			
		};
		
	}

}
