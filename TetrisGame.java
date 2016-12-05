import javax.swing.JComponent;

/**
 * The TetrisGame class maintains a Tetris game.
 * @author Xuzhen Xinag
 * @version part 3
 *
 */
public class TetrisGame  {
	//remembering the tetris board
	private TetrisBoard tetrisBoard;
	//values corresponding to the move methods, used in printing
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int DOWN = 3;
	public static final int CW = 4;
	public static final int CCW = 5;
	//remember the number of cleared lines
	private int numLines;
	//remember the number of cleared tetris
	private int tetrises;
	
	
	/**
	 * constructor
	 * containing a board
	 * add a piece when the game start
	 */
	public TetrisGame(){
		tetrisBoard = new TetrisBoard();
		tetrisBoard.addNewPiece();
	}
	
	/**
	 * Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 * @param moveType
	 */
	public void attemptMove (int moveType) {
		if (moveType == LEFT){
			tetrisBoard.moveLeft();
		}
		else if (moveType == RIGHT){
			tetrisBoard.moveRight();
		}
		else if (moveType == DOWN){
			//if the tetris cannot be move down, check whether a line can be removed and land a new piece
			if (!tetrisBoard.moveDown()){
				endRound();
			}
		}
		else if (moveType == CW){
			tetrisBoard.rotateCW();
		}
		else if (moveType == CCW){
			tetrisBoard.rotateCW();
		}


	}
	
	/**
	 * get the current tetris board
	 * @return tetrisBoard
	 */
	public TetrisBoard getTetrisBoard () {
		return tetrisBoard;
	}
	
	/**
	 * get number of cleared lines by calling the getNunRows method in the tetrisBoard class
	 * @return numLines, num of cleared lines
	 */
	public int getNumlines() {
		numLines = tetrisBoard.getNumRows();
		
		return numLines;
	}
	
	/**
	 * get number of cleared tetris by calling the getNunRows method in the tetrisBoard class
	 * devide the number of lines by 4 to get number of cleared tetris
	 * @return numLines, number of cleared lines
	 */
	public int getTetrises() {
		if (tetrisBoard.getNumRows() - numLines == 4){
			tetrises ++;
		}
		
		return tetrises;
	}
	
	/**
	 * when the piece cannot be moved down,
	 * add new piece
	 * check whether there is a filled line, if there is, remove the line 
	 * 
	 * if game ends, do nothing
	 */
	private void endRound() {
		if (!tetrisBoard.gameEnd()){
			tetrisBoard.landPiece();
			tetrisBoard.numberOfFormedLines();
			tetrisBoard.addNewPiece();
		}
	}
}
