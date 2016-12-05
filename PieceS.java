/**
 * PieceS class represents the S shape tetris piece
 * It is a subclass the TetrisPiece class
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class PieceS extends TetrisPiece{
	/**
	 * set up the shape and rotation for the piece
	 */
	public PieceS () {
		filledSquares = new boolean [][][] {
			{	
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false, false, false}
			},
			{	
				{true, false, false, false},
				{true,  true, false, false},
				{false, true, false, false},
				{false, false,  false, false}
			},
			{	
				{false, true, true, false},
				{true, true, false, false},
				{false, false, false, false},
				{false, false,  false, false}
			},
			{	
				{true,  false, false, false},
				{true,  true, false, false},
				{false, true, false, false},
				{false, false,  false, false}
			}
			
		};
		
	}

}
