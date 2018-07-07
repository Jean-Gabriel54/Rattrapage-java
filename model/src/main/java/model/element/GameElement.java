package model.element;

import java.awt.Point;
import java.util.List;

public abstract class  GameElement {
	private Point position;
	private List<GameElement> map;
	private boolean isAlive = true;
	public GameElement(Point position) {
		setPosition(position);
	}
	
	public void behaviour(EContext context) {
		return;
	}
	
	
	
	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
}
