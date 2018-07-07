package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.element.EDirection;
import model.element.GameElement;
import model.element.LightElement;
import model.element.WallElement;
import view.EElement;
import view.Element;

public class Game {
	
	private Dimension mapSize;
	private List<GameElement> elements;
	private List<GameElement> toAddElements;

	
	public Game(Dimension mapSize) {
		setMapSize(mapSize);
		elements = new ArrayList<GameElement>();
		toAddElements = new ArrayList<GameElement>();
		getElements().add(new LightElement(0, this, new Point(0, 0), EDirection.BOTTOM));
		getElements().add(new LightElement(1, this, new Point(mapSize.width - 1, mapSize.height - 1), EDirection.TOP));
	}
	
	public void getDataToView() {
		List<Element> x = new ArrayList<Element>();
		for (GameElement element : getElements()) {
			if(element.isAlive() == true) {
				if(element instanceof WallElement) {
					x.add(new Element(EElement.WALL, ((WallElement) element).getCreator()));
				}else if(element instanceof LightElement) {
					x.add(new Element(EElement.PLAYER, ((LightElement) element).getPlayerId()));
				}
			}
		}
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

}
