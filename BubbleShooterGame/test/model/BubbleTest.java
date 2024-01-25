package model;

public class BubbleTest {

    private Bubble bubble;

    @BeforeEach
    public void setUp() {
        bubble = new Bubble(Color.RED);
    }

    @Test
    public void testGetCenterLocationWhenBubbleLocationIsSetThenReturnCorrectLocation() {
        // Arrange
        Point expectedLocation = new Point(15, 15);
        bubble.setLocation(new Point(0, 0));

        // Act
        Point actualLocation = bubble.getCenterLocation();

        // Assert
        assertEquals(expectedLocation, actualLocation, "The center location of the bubble is not correct.");
    }

    @Test
    public void testGetCenterLocationWhenBubbleLocationIsNotSetThenReturnNull() {
        // Act
        Point actualLocation = bubble.getCenterLocation();

        // Assert
        assertNull(actualLocation, "The center location of the bubble should be null when the location is not set.");
    }

    @Test
    public void testGetRandomColorWhenBoundIsLessThanEightThenReturnColor() {
        // Arrange
        int bound = 5;

        // Act
        Color color = Bubble.getRandomColor(bound);

        // Assert
        assertNotNull(color, "The color should not be null when the bound is less than eight.");
    }

    @Test
    public void testGetRandomColorWhenBoundIsGreaterThanEightThenReturnColor() {
        // Arrange
        int bound = 10;

        // Act
        Color color = Bubble.getRandomColor(bound);

        // Assert
        assertNotNull(color, "The color should not be null when the bound is greater than eight.");
    }

    @Test
    public void testMarkWhenBubbleIsUnmarkedThenBubbleIsMarked() {
        // Act
        bubble.mark();

        // Assert
        assertTrue(bubble.isMarked(), "The bubble should be marked after calling the mark method.");
    }

    @Test
    public void testUnmarkWhenBubbleIsMarkedThenBubbleIsUnmarked() {
        // Arrange
        bubble.mark();

        // Act
        bubble.unmark();

        // Assert
        assertFalse(bubble.isMarked(), "The bubble should be unmarked after calling the unmark method.");
    }

    @Test
    public void testSetVisibleWhenBubbleIsInvisibleThenBubbleIsVisible() {
        // Act
        bubble.setVisible(true);

        // Assert
        assertTrue(bubble.isVisible(), "The bubble should be visible after calling the setVisible method with true.");
    }

    @Test
    public void testSetVisibleWhenBubbleIsVisibleThenBubbleIsInvisible() {
        // Arrange
        bubble.setVisible(true);

        // Act
        bubble.setVisible(false);

        // Assert
        assertFalse(bubble.isVisible(), "The bubble should be invisible after calling the setVisible method with false.");
    }

    @Test
    public void testGetRandomColorWhenBoundIsLessThanOrEqualTo8ThenReturnValidColor() {
        // Arrange
        int bound = 8;

        // Act
        Color color = Bubble.getRandomColor(bound);

        // Assert
        assertTrue(color == Color.green || color == Color.pink || color == Color.yellow || color == Color.red || color == Color.cyan || color == Color.magenta || color == Color.orange || color == Color.black, "The color should be one of the predefined colors.");
    }

    @Test
    public void testGetRandomColorWhenBoundIsGreaterThan8ThenReturnNull() {
        // Arrange
        int bound = 9;

        // Act
        Color color = Bubble.getRandomColor(bound);

        // Assert
        assertNull(color, "The color should be null when the bound is greater than 8.");
    }
}