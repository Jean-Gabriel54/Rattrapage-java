package model.element;

import java.awt.Point;

public class WallElement extends GameElement {
	private int creatorId;
	private int health = 3;
	public WallElement(Point position, int creatorId) {
		super(position);
		setCreator(creatorId);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the creator
	 */
	public int getCreator() {
		return creatorId;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(int creatorId) {
		this.creatorId = creatorId;
	}
	
	@Override
	public void behaviour(EContext context) {
		if (context == EContext.beforeMoving) {
			setHealth(getHealth() - 1);
			if(getHealth() == 0) {
				super.setAlive(false);
			}
		}
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
}
