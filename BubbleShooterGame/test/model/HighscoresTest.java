package model;

public class HighscoresTest {
    private Highscores highscores;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        private Logger logger;
        highscores = new Highscores();
        System.setOut(new PrintStream(outContent));
        logger = Logger.getLogger(Highscores.class.getName());
        logger.setLevel(Level.ALL);
        logger.addHandler(new StreamHandler(logger.log(""), null));
    }

    @Test
    public void testPrintWhenMultipleEntriesThenPrintAllEntries() {
        HighscoreEntry entry1 = new HighscoreEntry("Player1", 100, 10, 5);
        HighscoreEntry entry2 = new HighscoreEntry("Player2", 200, 20, 10);
        highscores.addEntry(entry1);
        highscores.addEntry(entry2);

        highscores.print();

        String expectedOutput = "Player1 100 10 5\nPlayer2 200 20 10\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintWhenNoEntriesThenPrintNothing() {
        highscores.print();

        String expectedOutput = "";
        assertEquals(expectedOutput, outContent.toString());
    }
}