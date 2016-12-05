import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * TetrisGUIController plays the tetris game in a GUI frame, moving the tetris piece by using arrow keys
 * rotating the tetris piece by typing "x" and "z"
 * @author Xuzhen Xiang
 *
 */
public class TetrisGUIController extends JPanel implements KeyListener {
	//initialize a new game
	private TetrisGame game = new TetrisGame();
	//initialize the tetris view
	private TetrisGUIView view = new TetrisGUIView(game.getTetrisBoard());
	//JLabel showing the number of cleared lines
	private JLabel linesLabel;
	//JLabel showing the number of cleared tetrises
	private JLabel tetrisesLabel;
	//timer controlling fall of a piece
	private Timer gameTimer;
	//drop rate for a falling piece
	private int dropRate = 1000;
	
	/**
	 * Constructor 
	 * create the GUI view
	 * set up the timer
	 * add KeyListener
	 */
	public TetrisGUIController() {
		super(new BorderLayout());
		setupTimer();
		createView();
		
		setFocusable(true);
		addKeyListener(this);
	}
	
	/**
	 * set up the timer
	 * When timer passes 1 second, move the piece down 1 unit
	 */
	private void setupTimer() {
		
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//move the current piece down
				game.attemptMove(TetrisGame.DOWN);
		    	refreshDisplay();
			}
		};
		
		//Initialize the timer with 1 second rate
		gameTimer = new Timer(dropRate, taskPerformer);
		
		//Only start the timer when game is not end
		if (!game.getTetrisBoard().gameEnd()){
			gameTimer.start();
		}


	}
	
	/**
	 * create GUI components
	 * create two JLabel, showing scores
	 * put the two JLabel at the North of a BorderLayout panel
	 * put the game view at the center of a BorderLayout panel
	 */
	private void createView() {
		//create a score panel containing 2 score labels
		JPanel scorePanel = new JPanel();
		//set the score panel as BoxLayout
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
		
		//initialize 2 score label
		linesLabel = new JLabel ("Lines cleared: " + game.getNumlines());
		tetrisesLabel = new JLabel ("Tetrises cleared: " + game.getTetrises() );
		
		//add 2 score label to the score panel
		scorePanel.add(linesLabel);
		scorePanel.add(tetrisesLabel);
		
		//add the score panel to the north of the frame
		add(scorePanel, BorderLayout.NORTH);
		//add the game view at the center of the frame
		add(view, BorderLayout.CENTER);		
		
		refreshDisplay();

	}
	
	/**
	 * repaint the current piece
	 * update scores
	 * if game is over, show "game over" 
	 */
	private void refreshDisplay() {
		view.repaint();
		linesLabel.setText("Lines cleared: " + game.getNumlines());
		tetrisesLabel.setText("Tetrises cleared: " + game.getTetrises());
		
		if (game.getTetrisBoard().gameEnd()){
			linesLabel.setText("Game Over");
			tetrisesLabel.setText("Game Over");
		}

		
	}
	
	
	/**
	 * When the user presses the "down arrow" key, move the current piece down
	 * When the user presses the "left arrow" key, move the current piece to the left
	 * When the user presses the "right arrow" key, move the current piece to the right
	 * @param e the key that is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT) {
			
			game.attemptMove(TetrisGame.RIGHT);
			refreshDisplay();
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	    	game.attemptMove(TetrisGame.DOWN);
	    	refreshDisplay();
	    }
	    else if (key == KeyEvent.VK_LEFT) {
	    	game.attemptMove(TetrisGame.LEFT);
	    	refreshDisplay();
	    }
	    
	}

	/**
	 * Move the circle when a key is released
	 * @param e the key that is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	/**
	 * When the user type "x", rotate the piece clockwise
	 * When the user type "z", rotate the piece counterclockwise
	 * @param e the key that is pressed and released
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if (keyChar == 'x'){
			game.attemptMove(TetrisGame.CW);
			refreshDisplay();
		}
		else if (keyChar == 'z'){
			game.attemptMove(TetrisGame.CCW); 
			refreshDisplay();
		}
	}
	

}
