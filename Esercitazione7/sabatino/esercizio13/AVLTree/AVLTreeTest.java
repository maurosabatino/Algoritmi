package sabatino.esercizio13.AVLTree;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AVLTreeTest {
	public static void main(String[]args){
		AVLTree avl = new AVLTree();
		/*avl.put(new Elem("mario", 10));
		avl.put(new Elem("mario", 9));
		avl.put(new Elem("mario", 8));
		avl.put(new Elem("mario", 7));
		avl.put(new Elem("mario", 6));
		avl.put(new Elem("mario", 5));
		avl.put(new Elem("mario", 4));
		avl.put(new Elem("mario", 3));
		avl.put(new Elem("mario", 2));
		avl.put(new Elem("mario", 1));
		disegnaAlbero(avl,"inserimenti");
		avl.checkBalance();*/
		for(int i = 1;i<=10;i++){
			avl.put(new Elem(""+i,i));
			//disegnaAlbero(avl,"inserimento  di "+i+"");
		}
		avl.remove(9);
		avl.remove(10);
		//avl.remove(4);
	disegnaAlbero(avl,"cancellazione");
		//AVLTree cancella = avl;
		//cancella.remove(11);
		//disegnaAlbero(cancella,"cancellazione");
		avl.checkBalance();
		
	}
	public static void disegnaAlbero(AVLTree avl,String title){
		JFrame frame = new JFrame();
		JPanel controlPanel = new JPanel();
		GraphicsEnvironment ge = getLocalGraphicsEnvironment();
    Rectangle bounds = ge.getMaximumWindowBounds();
    int x = bounds.x + bounds.width/4;
    int y = bounds.y + bounds.height/4;
    frame.setTitle(title);
    frame.setBounds(x,y,2*bounds.width/3,2*bounds.height/3);
    frame.add(BorderLayout.CENTER, new DrawingPanel(avl));
    frame.add(BorderLayout.SOUTH, controlPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
}
