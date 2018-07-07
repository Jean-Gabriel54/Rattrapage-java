package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import model.element.EDirection;
import model.element.GameElement;
import model.element.LightElement;

public class Game {
	
	private Dimension mapSize;
	private List<GameElement> elements;

	
	public Game(Dimension mapSize) {
		setMapSize(mapSize);
		getElements().add(new LightElement(getElements(), new Point(0, 0), EDirection.BOTTOM));
		getElements().add(new LightElement(getElements(), new Point(mapSize.width - 1, mapSize.height - 1), EDirection.TOP));
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

}
