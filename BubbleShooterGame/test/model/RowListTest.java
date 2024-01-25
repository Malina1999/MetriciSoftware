package model;

public class RowListTest {

    @Test
    public void testIsFullWhenFullThenTrue() {
        // Arrange
        RowList rowList = new RowList(true);

        // Act
        boolean result = rowList.isFull();

        // Assert
        assertTrue(result, "Expected isFull to return true when the row is a full row");
    }

    @Test
    public void testIsFullWhenNotFullThenFalse() {
        // Arrange
        RowList rowList = new RowList(false);

        // Act
        boolean result = rowList.isFull();

        // Assert
        assertFalse(result, "Expected isFull to return false when the row is not a full row");
    }
}