/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Aditya
 */
public class DragPanel extends JPanel {
    
    private Point clickLocation;
    private Rectangle block = new Rectangle (10, 10, 30, 30);
    private Color rectColor = Color.RED;
    private Point clickDiff;
    private static final int PANEL_SIZE = 250;
            
    public DragPanel() {
        super();
        this.setBackground(Color.BLACK);
        addMouseListener(onClickListener);
        addMouseMotionListener(moveListener);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(rectColor);
        g2.fill(block);
        g2.draw(block);
    }
    
    public static boolean rectInPanelBounds(int x, int y, int width, int height) {
        return x > 0 && y > 0 && x + width < PANEL_SIZE && y + height < PANEL_SIZE;
    }
    
    public static boolean clickInRectBounds(int x, int y, int rx, int ry, int rwidth, int rheight) {
        return rx < x && ry < y && rx + rwidth > x && ry + rheight > y;
    }
    
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
