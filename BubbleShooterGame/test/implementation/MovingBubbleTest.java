package implementation;

public class MovingBubbleTest {

    @Test
    public void testMoveWhenBubbleDoesNotCollideWithWallThenMoveBubble() {
        // Arrange
        Bubble baseBubble = new Bubble(Color.RED);
        baseBubble.setLocation(new Point(100, 100));
        MovingBubble movingBubble = new MovingBubble(baseBubble, new Point(200, 200));

        // Act
        movingBubble.move();

        // Assert
        assertEquals(105, movingBubble.getLocation().x);
        assertEquals(105, movingBubble.getLocation().y);
    }

    @Test
    public void testMoveWhenBubbleCollidesWithLeftWallThenInvertStepX() {
        // Arrange
        Bubble baseBubble = new Bubble(Color.RED);
        baseBubble.setLocation(new Point(-10, 100));
        MovingBubble movingBubble = new MovingBubble(baseBubble, new Point(-200, 200));

        // Act
        movingBubble.move();

        // Assert
        assertTrue(movingBubble.getLocation().x >= 0);
    }

    @Test
    public void testMoveWhenBubbleCollidesWithRightWallThenInvertStepX() {
        // Arrange
        Bubble baseBubble = new Bubble(Color.RED);
        baseBubble.setLocation(new Point(430, 100));
        MovingBubble movingBubble = new MovingBubble(baseBubble, new Point(600, 200));

        // Act
        movingBubble.move();

        // Assert
        assertTrue(movingBubble.getLocation().x <= 420 - 1 - 2 * (Bubble.RADIUS + 1));
    }
}