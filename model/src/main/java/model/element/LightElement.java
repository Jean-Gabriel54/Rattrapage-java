package model.element;

import java.awt.Point;
import model.Game;

public class LightElement extends GameElement{
	private EDirection direction;
	private Game game;
	private int playerId;
	private Point previousPosition;
	public LightElement(int playerId, Game game, Point position, EDirection direction) {
		super(position);
		setDirection(direction);
		setGame(game);
		setPlayerId(playerId);
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
			setPreviousPosition(getPosition());
			setPosition(new Point(super.getPosition().x + padding.x, super.getPosition().y + padding.y));

		}else if(context == EContext.afterMoving) {
			Point padding = getMovementPadding();
			getGame().getToAddElements().add(new WallElement(new Point(super.getPosition().x + padding.x * -1, super.getPosition().y + padding.y * -1), getPlayerId()));
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
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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

	/**
	 * @return the previousPosition
	 */
	public Point getPreviousPosition() {
		return previousPosition;
	}

	/**
	 * @param previousPosition the previousPosition to set
	 */
	public void setPreviousPosition(Point previousPosition) {
		this.previousPosition = previousPosition;
	}


}
