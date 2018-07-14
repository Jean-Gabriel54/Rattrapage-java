package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.element.EContext;
import model.element.EDirection;
import model.element.GameElement;
import model.element.LightElement;
import model.element.WallElement;

public class Game {
	
	private Dimension mapSize;
	private List<GameElement> elements;
	private List<GameElement> toAddElements;
	private GameStatement gameStatement;
	
	public Game(Dimension mapSize) {
		setMapSize(mapSize);
		elements = new ArrayList<GameElement>();
		toAddElements = new ArrayList<GameElement>();
		getElements().add(new LightElement(0, this, new Point(0, 0), EDirection.BOTTOM));
		getElements().add(new LightElement(1, this, new Point(mapSize.width - 1, mapSize.height - 1), EDirection.TOP));
		setGameStatement(new GameStatement());
	}
	
	public void update() {
		getGameStatement().setTime(getGameStatement().getTime() + 1);
		int playerAlive = 0;
		for (GameElement element: getElements()) {
			element.behaviour(EContext.beforeMoving);
		}
		getElements().addAll(getToAddElements());
		getToAddElements().clear();
		for (GameElement element: getElements()) {
			element.behaviour(EContext.afterMoving);
		}
		getElements().addAll(getToAddElements());
		getToAddElements().clear();

		for (GameElement element: getElements()) {
			boolean ok = true;
			if(element instanceof LightElement && element.isAlive()) {
				for (GameElement element2: getElements()) {
					if(element != element2 && element.isAlive() && element2.isAlive()) {
						//System.out.println("compare " + element.toString() + " and " + element2.toString() + "Alive: "+  element2.isAlive());
						if(element.getPosition().x == element2.getPosition().x && element.getPosition().y == element2.getPosition().y) {
							ok = false;
						}
					}
				}
				if(ok) {
					playerAlive++;
					getGameStatement().setWinner(((LightElement) element).getPlayerId());
				}
			}
		}
		getGameStatement().setAlivePlayer(playerAlive);

	}
	
	/**
	 * @return the mapSize
	 */
	public Dimension getMapSize() {
		return mapSize;
	}
	
	/**
	 * @param mapSize the mapSize to set
	 */
	public void setMapSize(Dimension mapSize) {
		this.mapSize = mapSize;
	}

	/**
	 * @return the elements
	 */
	public List<GameElement> getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<GameElement> elements) {
		this.elements = elements;
	}
	
	
	/**
	 * @return an element
	 */
	public GameElement getElement(int i) {
		return elements.get(i);
	}

	/**
	 * @return the toAddElements
	 */
	public List<GameElement> getToAddElements() {
		return toAddElements;
	}

	/**
	 * @param toAddElements the toAddElements to set
	 */
	public void setToAddElements(List<GameElement> toAddElements) {
		this.toAddElements = toAddElements;
	}


	/**
	 * @return the gameStatement
	 */
	public GameStatement getGameStatement() {
		return gameStatement;
	}


	/**
	 * @param gameStatement the gameStatement to set
	 */
	public void setGameStatement(GameStatement gameStatement) {
		this.gameStatement = gameStatement;
	}

}
