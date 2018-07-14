package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import model.element.EContext;
import model.element.EDirection;
import model.element.GameElement;
import model.element.LightElement;
import model.element.WallElement;



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
	public GameStatement updateGame() {
		if(getGame() == null) {
			return null;
		}
		getGame().update();
		return getGame().getGameStatement();
		
		
	}
	
	@Override
	public List<String> getInstructionToView() {
		List<String> x = new ArrayList<String>();
		for (GameElement element : getGame().getElements()) {
			if(element.isAlive() == true) {
				if(element instanceof WallElement) {
					WallElement element_wall = (WallElement) element;
					if(element_wall.getHealth() == 0) {
						System.out.println("wall disappear");
						x.add("disappear;" + element.getPosition().x + ";" + element.getPosition().y);
					}else if(element_wall.getHealth() == WallElement.MAX_HEALTH) {
						x.add("appear;" + element.getPosition().x + ";" + element.getPosition().y + ";W;" + element_wall.getCreator() + ";");

					}else {
						System.out.println("pv " + element_wall.getHealth());

					}
				}else if(element instanceof LightElement) {
					LightElement element_light = (LightElement) element;
					if(element_light.getPreviousPosition() != null) {
						x.add("disappear;" + element_light.getPreviousPosition().x + ";" + element_light.getPreviousPosition().y);
					}
					x.add("appear;" + element_light.getPosition().x + ";" + element_light.getPosition().y + ";L;"+ element_light.getPlayerId() + ";");

				}
			}
		}
		return x;
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

	@Override
	public void movePlayer(int playerId, boolean toLeft) {
		// TODO Auto-generated method stub
		for (GameElement element : getGame().getElements()) {
			if(element instanceof LightElement) {
				LightElement lightE = (LightElement) element;
				if(lightE.getPlayerId() == playerId) {
					if(lightE.getDirection() == EDirection.BOTTOM) {
						if(!toLeft) {
							lightE.setDirection(lightE.getDirection().toLeft());
						}else {
							lightE.setDirection(lightE.getDirection().toRight());

						}
					}else {
						if(toLeft) {
							lightE.setDirection(lightE.getDirection().toLeft());
						}else {
							lightE.setDirection(lightE.getDirection().toRight());
						}
					}
				
				}
			}
		
		}
	}


}
