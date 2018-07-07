package model.element;

import java.awt.Point;
import java.util.List;

public class WallElement extends GameElement {
	private LightElement creator;
	private int health = 3;
	public WallElement(Point position, LightElement creator) {
		super(position);
		setCreator(creator);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the creator
	 */
	public LightElement getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(LightElement creator) {
		this.creator = creator;
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
