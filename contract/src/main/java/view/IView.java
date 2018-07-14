package view;

import java.awt.Point;
import java.util.List;

import controller.IController;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    //void updateView(List<String> elements);
   
	void appear( Point position, String element, String player); 
	void disappear( Point position);

		
		
    void createWindow(int width, int height);

	IController getController();

	void setController(IController controller);
}

