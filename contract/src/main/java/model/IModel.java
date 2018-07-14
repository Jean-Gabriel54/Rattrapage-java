package model;

import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
	public void initGame(int width, int height);
	public GameStatement updateGame();
	public List<String> getInstructionToView();
	void movePlayer(int playerId, boolean toLeft);

}
