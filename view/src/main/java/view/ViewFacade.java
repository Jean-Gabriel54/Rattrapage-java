package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.IController;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	private JFrame gui = null;
	private JLabel[][] labels;
	private IController controller;
	
	@Override
    public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
	}

	/**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
      
    }

    public void createWindow(int width, int height) {
    	if (gui != null) {
    		gui.setVisible(false); //you can't see me!
			gui.dispose(); //Destroy the JFrame object
		}
    	  gui = new JFrame("test");
    	  labels = new JLabel[width][height];
          gui.setSize(new Dimension(width * 10 +20, height * 10 + 50));
          gui.setVisible(true);	      
          gui.getContentPane().setBackground(Color.BLACK);
          System.out.println("showed");
          gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          gui.setLayout(null);
          
          gui.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (getController()!= null) {
					switch (e.getKeyCode())
				    {
				    	case KeyEvent.VK_NUMPAD6:
				    		System.out.println("viewfacade");
				    		getController().movePlayer(1, false);
				    		break;
				    	case KeyEvent.VK_NUMPAD4:
				    		getController().movePlayer(1, true);
				    		break;	
				    	case KeyEvent.VK_LEFT:
				    		getController().movePlayer(0, false);
				    		break;
				    	case KeyEvent.VK_RIGHT:
				    		getController().movePlayer(0, true);
				    		break;	 				    		
				    	default:
				    		break;
				    }
				}else {
					System.out.println("abc");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

    }
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    int zzz = 0;

    


	@Override
	public void appear(Point position, String element, String player) {
		int x = position.x;
		int y = position.y;
		JLabel lbl = new JLabel("");
		lbl.setBounds(new Rectangle(new Point(x * 10 , y *  10), new Dimension(10,10)));
		
		if(player.equals("0")) {
			if(element.charAt(0) == 'L') {
				lbl.setBackground(Color.RED);
			}else {
				lbl.setBackground(Color.PINK);

			}
		}else {
			if(element.equals("L")) {
				lbl.setBackground(Color.blue);

			}else {
				lbl.setBackground(Color.cyan);

			}
		}
		lbl.setOpaque(true);
		lbl.setVisible(true);
		gui.add(lbl);
		gui.setVisible(true);
        gui.repaint();
		labels[x][y] = lbl;
		
	}


	@Override
	public void disappear(Point position) {
		// TODO Auto-generated method stub
		int x = position.x;
		int y = position.y;
		if(labels[x][y] != null) {
			gui.remove(labels[x][y]);
		}
		
	}

}
