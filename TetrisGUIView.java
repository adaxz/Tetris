import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
/**
 * TetrisGUIView creates a GUI view for the tetris game
 * @author AdaXiang
 *
 */
public class TetrisGUIView extends JComponent {
	//remember the current game board
	private TetrisBoard board;

	/**
	 * Constructor
	 * @param b, game board
	 */
	public TetrisGUIView(TetrisBoard b) {
		board = b;
	}
	
	public void paint(Graphics g){
		
		//paint the board outline
		paintBoardOutline(g, computeBlockSize());
		
		//check if the blocks are on the board, if they are, paint those blocks
		for (int row = 0; row < TetrisBoard.NUM_ROWS; row ++){
			for (int col = 0; col < TetrisBoard.NUM_COLS; col ++){
				//check if blocks are on the board
				if(board.hasBlock(row, col)){
					//paint the block
					paintBlock(g, row, col, computeBlockSize());
				}
				
			}
	
		}
		
	}
	
	/**
	 * paint the game board outline
	 * @param g, the graphic object to draw on
	 * @param blockSize, the size of each block on the board
	 */
	private void paintBoardOutline(Graphics g, int blockSize){
		g.drawRect(0, 0, blockSize * TetrisBoard.NUM_COLS, blockSize * TetrisBoard.NUM_ROWS);
		
		
	}
	
	/**
	 * paint each block of a tetris piece
	 * @param g, the graphic object to draw on 
	 * @param row, the grid row position of the block
	 * @param col, the grid column position of the block
	 * @param blockSize, the size of each block on the board
	 */
	public void paintBlock(Graphics g, int row, int col, int blockSize){
		//draw the outline of each block
		g.setColor(Color.WHITE);
		g.drawRect(col * blockSize, row * blockSize, blockSize, blockSize);
		
		//draw a block
		g.setColor(Color.BLUE);
		g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize); 
		
		
	}
	
	/**
	 * compute the block size based on the window size
	 * @return getWidth()/10, the block size
	 */
	private int computeBlockSize(){
		// 1/10 of the window width is the width of a square block
		return getWidth()/10;
	}
}
