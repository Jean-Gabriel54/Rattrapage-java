package main;

import controller.ControllerFacade;
import model.ModelFacade;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	IView myView = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(myView, new ModelFacade());
        myView.setController(controller);
        controller.start();
        
    }

}
