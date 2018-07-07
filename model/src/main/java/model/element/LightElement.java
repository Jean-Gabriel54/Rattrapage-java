package model.element;

import java.awt.Point;
import java.util.List;

public class LightElement extends GameElement{
	private EDirection direction;
	private List<GameElement> map;
	public LightElement(List<GameElement> map, Point position, EDirection direction) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	
	public Point getMovementPadding() {
		int xPadding = 0;
		int yPadding = 0;
		switch (getDirection()) {
		case TOP:
			yPadding--;
			break;
		case BOTTOM:
			yPadding++;
			break;
		case LEFT:
			xPadding++;
			break;
		case RIGHT:
			xPadding--;
			break;
		default:
			break;			
		}
		
		return new Point(xPadding, yPadding);

	}

	@Override
	public void behaviour(EContext context) {
		if(context == EContext.beforeMoving) {
			Point padding = getMovementPadding();
			setPosition(new Point(super.getPosition().x + padding.x, super.getPosition().y + padding.y));

		}else if(context == EContext.afterMoving) {
			Point padding = getMovementPadding();
			getMap().add(new WallElement(new Point(super.getPosition().x + padding.x * -1, super.getPosition().y + padding.y * -1), this));
		}
	}

	/**
	 * @return the direction
	 */
	public EDirection getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(EDirection direction) {
		this.direction = direction;
	}
	/**
	 * @return the map
	 */
	public List<GameElement> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(List<GameElement> map) {
		this.map = map;
	}


}
