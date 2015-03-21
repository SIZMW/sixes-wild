package dragprototype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * @brief This class is used to create a custom panel with a rectangle that
 * can be dragged within the panel.
 * @author Aditya Nivarthi
 */
public class DragPanel extends JPanel {
    
    private Point clickLocation;
    private Rectangle block = new Rectangle (10, 10, 30, 30);
    private Color rectColor = Color.RED;
    private Point clickDiff;
    private static final int PANEL_SIZE = 250;
            
    /**
     * @brief Constructor for DragPanel. Sets the background and
     * adds the mouse listeners.
     */
    public DragPanel() {
        super();
        this.setBackground(Color.BLACK);
        addMouseListener(onClickListener);
        addMouseMotionListener(moveListener);
    }
    
    /**
     * @Override
     * @brief Paint component for painting the rectangle.
     * @param g The Graphics used to paint the rectangle
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(rectColor);
        g2.fill(block);
        g2.draw(block);
    }
    
    /**
     * @brief Static function to return whether a rectangle is within the panel bounds.
     * @param x X position of rectangle
     * @param y Y position of rectangle
     * @param width Width of rectangle
     * @param height Height of rectangle
     * @return True if within bounds, false otherwise.
     */
    public static boolean rectInPanelBounds(int x, int y, int width, int height) {
        return x > 0 && y > 0 && x + width < PANEL_SIZE && y + height < PANEL_SIZE;
    }
    
    /**
     * @brief Static function to return whether a point is within a rectangle. Used for
     * checking mouse clicks and presses.
     * @param x X position of point
     * @param y Y position of point
     * @param rx X position of rectangle
     * @param ry Y position of rectangle
     * @param rwidth Width of rectangle
     * @param rheight Height of rectangle
     * @return True of point is within rectangle, false otherwise.
     */
    public static boolean clickInRectBounds(int x, int y, int rx, int ry, int rwidth, int rheight) {
        return rx < x && ry < y && rx + rwidth > x && ry + rheight > y;
    }
    
    /**
     * @brief Mouse listener for when the mouse is pressed and released. Changes
     * the rectangle colors as needed.
     */
    private MouseListener onClickListener = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            clickLocation = e.getPoint();
            clickDiff = new Point(clickLocation.x - block.x, clickLocation.y - block.y);
            if (DragPanel.clickInRectBounds(clickLocation.x, clickLocation.y, block.x, block.y, block.width, block.height)) {
                rectColor = Color.YELLOW;
                repaint();
            }
        }
        
        public void mouseReleased(MouseEvent e) {
            rectColor = Color.RED;
            repaint();
        }
    };
     
    /**
     * @brief Mouse motion listener for when the mouse is moved or dragged. Changes the
     * rectangle colors as needed. and checks whether to move the rectangle if dragged.
     */
    private MouseMotionListener moveListener = new MouseMotionListener() {        
        public void mouseDragged(MouseEvent e) {
            Point dragLocation = e.getPoint();
            if (DragPanel.clickInRectBounds(dragLocation.x, dragLocation.y, block.x, block.y, block.width, block.height) && DragPanel.rectInPanelBounds(dragLocation.x - clickDiff.x, dragLocation.y - clickDiff.y, block.width, block.height)) {
                block.setLocation(dragLocation.x - clickDiff.x, dragLocation.y - clickDiff.y);
                rectColor = Color.GREEN;
                repaint();
            }
        }
        
        public void mouseMoved(MouseEvent e) {
        }
    };
}
