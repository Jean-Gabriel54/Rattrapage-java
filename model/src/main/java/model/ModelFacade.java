package model;

import java.awt.Dimension;
import model.element.EContext;
import model.element.GameElement;
import model.element.LightElement;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	private Game game;
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

	@Override
	public void initGame(int width, int height) {
		// TODO Auto-generated method stub
		setGame(new Game(new Dimension(width, height)));
	}

	@Override
	public void updateGame() {
		if(game == null) {
			return;
		}
		
		for (GameElement element: getGame().getElements()) {
			element.behaviour(EContext.beforeMoving);
		}
		getGame().getElements().addAll(getGame().getToAddElements());

		for (GameElement element: getGame().getElements()) {
			element.behaviour(EContext.afterMoving);
		}
		getGame().getElements().addAll(getGame().getToAddElements());
		
		for (GameElement element: getGame().getElements()) {
			for (GameElement element2: getGame().getElements()) {
				if(element.getPosition() == element2.getPosition() && element != element2) {
					if(element instanceof LightElement) {
						element.setAlive(false);
					}
					if(element2 instanceof LightElement) {
						element.setAlive(false);
					}	
				}
			}		
		}
	
	}
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}


}
