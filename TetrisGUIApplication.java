import javax.swing.JFrame;

/**
 * Application class, containing a main method
 * creating a JFrame for showing the current game
 * @author Xuzhen Xiang
 * @version part3
 *
 */
public class TetrisGUIApplication {
	/**
	 * main method. Starts game by calling controller constructor
	 * create a JFrame for showing the game
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create a new JFrame
		JFrame tetrisWindow = new JFrame ("Tetris");
		//add the controller class to the frame
		tetrisWindow.add(new TetrisGUIController());
		//set the size for the frame
		tetrisWindow.setSize(400, 780);
		//when the frame is closed, exit the game
		tetrisWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the frame to be visible
		tetrisWindow.setVisible(true);
		
	}

}