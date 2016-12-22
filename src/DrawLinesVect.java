
/**
 * a program to move ball in roundome motion
 *
 * @author: Amr Abd El Latief
 * @version 2.1
 * @since	2.1
 * @see Graphics
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.lang.Math.*;
import java.awt.Point;
import javax.swing.JColorChooser;

public class DrawLinesVect extends Applet implements Runnable, MouseListener, MouseMotionListener, ActionListener {

// 0 for line , 1 for rect , 2 for rounded rect , 3 for oval , 
    Thread th;
    Vector<Shape> shapeVector;
    Color uC;

// buttons 
    Button line;
    Button rect;
    Button roundrect;
    Button oval;
    Button freeHand;
    Button nofill;
    Button fill;
    Button colorB;
    Button undo;
    Button clear;

// vars
    boolean filled = false;
    int shapeT = 0;

    /**
     * this method adds and start of recording of new shape
     *
     * @param e mouse event
     */
    public void mousePressed(MouseEvent e) {

        shapeVector.add(new Shape());
        shapeVector.lastElement().setStartX(e.getX());
        shapeVector.lastElement().setStartY(e.getY());
        shapeVector.lastElement().setCurrentX(e.getX());
        shapeVector.lastElement().setCurrentY(e.getY());
        shapeVector.lastElement().setShapeType(shapeT);
        shapeVector.lastElement().setIsFilled(filled);
        shapeVector.lastElement().setColor(uC);

        if (shapeVector.lastElement().getShapeType() == 4) {

            shapeVector.lastElement().pointVector.add(new Point(e.getX(), e.getY()));

        }

    }

    /**
     * this methode terminates the shape to start a new one
     *
     * @param e mouse event release
     */
    public void mouseReleased(MouseEvent e) {
        shapeVector.lastElement().setCurrentX(e.getX());
        shapeVector.lastElement().setCurrentY(e.getY());

    }

    public void mouseEntered(MouseEvent e) {

        // not supported 
    }

    public void mouseExited(MouseEvent e) {

        // not supported 
    }

    public void mouseClicked(MouseEvent e) {
        // not supported 

    }

///////////////////////////////////////
    /**
     * this method draws the shape while the mouse is dragged
     *
     * @param e the mouse event
     */
    public void mouseDragged(MouseEvent e) {

        if ((e.getX() <= getWidth()) & (e.getY() <= getHeight())) {
            shapeVector.lastElement().setCurrentX(e.getX());
            shapeVector.lastElement().setCurrentY(e.getY());

            if (shapeVector.lastElement().getShapeType() == 4) {

                shapeVector.lastElement().pointVector.add(new Point(e.getX(), e.getY()));

            }
            repaint();
        }
    }

    /**
     * the initialization and construction of components
     *
     * @see Applet -> init() for more information
     */
    public void init() {

        th = new Thread(this);
        th.start();
        addMouseListener(this);
        addMouseMotionListener(this);
        shapeVector = new Vector<Shape>();
        line = new Button("Line");
        rect = new Button("Rect");
        roundrect = new Button("R-Rect");
        oval = new Button("Oval");
        freeHand = new Button("Hand");
        nofill = new Button("No Fill");
        fill = new Button("Fill");
        colorB = new Button("Choose Color");
        uC = new Color(0, 0, 255);

        undo = new Button("undo");
        clear = new Button("clear");

//*********************connect
        line.addActionListener(this);
        rect.addActionListener(this);
        roundrect.addActionListener(this);
        oval.addActionListener(this);
        freeHand.addActionListener(this);
        nofill.addActionListener(this);
        fill.addActionListener(this);
        colorB.addActionListener(this);
        undo.addActionListener(this);
        clear.addActionListener(this);

//*******************add
        add(line);
        add(rect);
        add(roundrect);
        add(oval);
        add(freeHand);
        add(nofill);
        add(fill);
        add(colorB);
        add(undo);
        add(clear);

//************************
    }

    /**
     * this function paint the Applet each time called
     *
     * @param g the graphics to paint with
     * 
     */
    public void paint(Graphics g) {
        int width, height, pointVectorS;

        for (int counter = 0; counter < shapeVector.size(); counter++) {

            g.setColor(shapeVector.elementAt(counter).getColor());

            if (shapeVector.elementAt(counter).getIsFilled() == false) {
                if (shapeVector.elementAt(counter).getShapeType() == 0) {//line
                    g.drawLine(shapeVector.elementAt(counter).getStartX(), shapeVector.elementAt(counter).getStartY(), shapeVector.elementAt(counter).getCurrentX(), shapeVector.elementAt(counter).getCurrentY());

                } else if (shapeVector.elementAt(counter).getShapeType() == 1) {//rect
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.drawRect(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height);

                } else if (shapeVector.elementAt(counter).getShapeType() == 2) {//Rounded- rect
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.drawRoundRect(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height, 20, 20);

                } else if (shapeVector.elementAt(counter).getShapeType() == 3) {//oval
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.drawOval(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height);

                } else if (shapeVector.elementAt(counter).getShapeType() == 4) {//free hand

                    if (shapeVector.lastElement().pointVector.size() == 0) {
                        System.out.println("no points");
                    } else {

                        for (Point p : shapeVector.lastElement().pointVector) {
                            pointVectorS = shapeVector.lastElement().pointVector.size();
                            g.drawLine(shapeVector.lastElement().pointVector.elementAt(pointVectorS - 2).x, shapeVector.lastElement().pointVector.elementAt(pointVectorS - 2).y,
                                    shapeVector.lastElement().pointVector.lastElement().x, shapeVector.lastElement().pointVector.lastElement().y);
                        }
                    }
                }//

            } else {//filled shape

                if (shapeVector.elementAt(counter).getShapeType() == 0) {//line
                    g.drawLine(shapeVector.elementAt(counter).getStartX(), shapeVector.elementAt(counter).getStartY(), shapeVector.elementAt(counter).getCurrentX(), shapeVector.elementAt(counter).getCurrentY());

                } else if (shapeVector.elementAt(counter).getShapeType() == 1) {//rect
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.fillRect(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height);

                } else if (shapeVector.elementAt(counter).getShapeType() == 2) {//Rounded- rect
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.fillRoundRect(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height, 20, 20);

                } else if (shapeVector.elementAt(counter).getShapeType() == 3) {//oval
                    width = Math.abs(shapeVector.elementAt(counter).getCurrentX() - shapeVector.elementAt(counter).getStartX());
                    height = Math.abs(shapeVector.elementAt(counter).getCurrentY() - shapeVector.elementAt(counter).getStartY());

                    g.fillOval(shapeVector.elementAt(counter).getMinX(), shapeVector.elementAt(counter).getMinY(), width, height);

                } else if (shapeVector.elementAt(counter).getShapeType() == 4) {//free hand
                    if (shapeVector.lastElement().pointVector.size() >= 0) {
                        System.out.println("no points");
                    } else {

                        for (Point p : shapeVector.elementAt(counter).pointVector) {
                            pointVectorS = shapeVector.lastElement().pointVector.size();
                            g.drawLine(shapeVector.elementAt(counter).pointVector.elementAt(pointVectorS - 2).x, shapeVector.elementAt(counter).pointVector.elementAt(pointVectorS - 2).y,
                                    shapeVector.elementAt(counter).pointVector.lastElement().x, shapeVector.elementAt(counter).pointVector.lastElement().y);
                        }
                    }
                }//

            }
        }//last of vector for				

    }// last of paint function

    /**
     * the begining of run of the  Applet
     */
    public void run() {
        while (true) {
            repaint();

            try {
                Thread.sleep(3);
            } catch (Exception e) {

                e.printStackTrace();
            }

        }
    }

    
    /**
     * this method is responsible for handling all the events of the components 
     * @param e the event received  
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == line) {
            shapeT = 0;
        } else if (e.getSource() == rect) {
            shapeT = 1;
        } else if (e.getSource() == roundrect) {
            shapeT = 2;
        } else if (e.getSource() == oval) {
            shapeT = 3;
        } else if (e.getSource() == freeHand) {
            shapeT = 4;
        } else if (e.getSource() == nofill) {
            filled = false;
        } else if (e.getSource() == fill) {
            filled = true;
        } else if (e.getSource() == colorB) {
            uC = JColorChooser.showDialog(null, "Select a Color", Color.blue);

        } else if (e.getSource() == undo) {
            shapeVector.remove(shapeVector.size() - 1);

        } else if (e.getSource() == clear) {
            shapeVector.removeAllElements();

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
