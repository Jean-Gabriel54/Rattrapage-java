package controller;

import java.awt.Point;

import javax.sql.rowset.serial.SerialArray;

import model.GameStatement;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, Runnable {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    	
    private final int HEIGHT = 85;
    private final int WIDTH = 85;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     */
    public void start() {
        this.getView().displayMessage("Bienvenue dans TRON");
        this.getModel().initGame(HEIGHT, WIDTH);
        this.getView().createWindow(HEIGHT, WIDTH);
        this.run();
    }
    
    
    

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	@Override
	public void run() {
		GameStatement gameStatus = getModel().updateGame();
		// TODO Auto-generated method stub
		while(gameStatus.getAlivePlayer() > 1) {
			updateView();
			gameStatus = getModel().updateGame();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String message;
		if(gameStatus.getAlivePlayer() > 0) {
			message = "Game over, winner: " + gameStatus.getWinner();
		}else {
			message = "Game over, there is no winner: " + gameStatus.getWinner();
		}
		message += " time: " + gameStatus.getTime() + " tick";
		getView().displayMessage(message);
		
	}
	
	public void updateView() {
		for (String instruction : getModel().getInstructionToView()) {
			String param[] = instruction.split(";");
			if(param[0].equals("appear")) {
				getView().appear(new Point(Integer.parseInt(param[1]), Integer.parseInt(param[2])),  param[3], param[4]);
			}else if(param[0].equals("disappear")) {
				getView().disappear(new Point(Integer.parseInt(param[1]), Integer.parseInt(param[2])));

			}else {
				System.out.println("not found param: " + param[0]);
			}
		}
	}
	
	public void movePlayer(int playerId, boolean toLeft) {
		getModel().movePlayer(playerId, toLeft);
	}
}
