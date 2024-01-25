package implementation;

import interfaces.BubbleMover;
import interfaces.HighScoreManager;
import model.Bubble;
import utils.Constants;

import java.awt.Point;

public class MovingBubble extends Bubble implements BubbleMover, HighScoreManager {

    private boolean moving;
    private double stepX;
    private double stepY;
    private double locX;
    private double locY;
    private static double fiveSTEP= 5;


    /**
     * constructor, initiates the bubble sets its location and
     * calculates the direction of the shot and the lengths of
     * the steps in both directions
     *
     * @param b   the bubble that serves as the base of the construction
     * @param dir the direction of the shot (position of the pointer)
     */
    public MovingBubble(Bubble b, Point dir) {
        super(b.getColor());
        loc = new Point(b.getLocation());
        locX = loc.x;
        locY = loc.y;
        setVisible(true);
        moving = true;
        double offsetX = dir.x - (double)Constants.FIELD_SIZE_X / 2;
        double offsetY = dir.y - (double)Constants.FIELD_SIZE_Y;
        double dist = Math.sqrt(Math.pow(offsetX, 2) + Math.pow(offsetY, 2));
        stepX = offsetX / dist * fiveSTEP;
        stepY = offsetY / dist * fiveSTEP;
    }

    /**
     * returns whether the bubble is moving
     *
     * @return true is the bubble is moving, else false
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * sets if the bubble is moving
     *
     * @param x true is the bubble should move, else false
     */
    public void setMoving(boolean x) {
        moving = x;
    }

    /**
     * move the bubble one step forward, and makes the bubble bounce off
     * the wall if it collides woth it
     */
    public void move() {
        if (locX + stepX < 0) {
            locX = (int) -(locX + stepX);
            stepX = -stepX;
        } else if (locX + stepX > Constants.FIELD_SIZE_X - 1 - 2 * (Bubble.RADIUS + 1)) {
            locX = (int) ((Constants.FIELD_SIZE_X - 1 - 2 * (Bubble.RADIUS + 1)) * 2 - (locX + stepX));
            stepX = -stepX;
        } else
            locX += stepX;
        locY += stepY;
        loc.x = (int) locX;
        loc.y = (int) locY;
    }

}
