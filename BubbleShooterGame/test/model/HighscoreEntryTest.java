package model;

public class HighscoreEntryTest {

    public static final String PLAYER_1 = "Player1";
    public static final String PLAYER_2 = "Player2";

    @Test
    public void testCompareToWhenFirstObjectHasHigherScoreThenReturnNegativeOne() {
        // Arrange
        HighscoreEntry highscoreEntry1 = new HighscoreEntry(PLAYER_1, 100, 10, 5);
        HighscoreEntry highscoreEntry2 = new HighscoreEntry(PLAYER_2, 50, 10, 5);

        // Act
        int result = highscoreEntry1.compareTo(highscoreEntry2);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testCompareToWhenBothObjectsHaveSameScoreThenReturnZero() {
        // Arrange
        HighscoreEntry highscoreEntry1 = new HighscoreEntry(PLAYER_1, 100, 10, 5);
        HighscoreEntry highscoreEntry2 = new HighscoreEntry(PLAYER_2, 100, 10, 5);

        // Act
        int result = highscoreEntry1.compareTo(highscoreEntry2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareToWhenFirstObjectHasLowerScoreThenReturnOne() {
        // Arrange
        HighscoreEntry highscoreEntry1 = new HighscoreEntry(PLAYER_1, 50, 10, 5);
        HighscoreEntry highscoreEntry2 = new HighscoreEntry(PLAYER_2, 100, 10, 5);

        // Act
        int result = highscoreEntry1.compareTo(highscoreEntry2);

        // Assert
        assertEquals(1, result);
    }
}