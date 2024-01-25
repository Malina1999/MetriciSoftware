package model;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameTest {

    private Game game;
    private MainFrame mainFrame;

    @BeforeEach
    public void setUp() {
        game = new Game(5, 3, new Canvas());
        mainFrame = new MainFrame();
    }

    @AfterEach
    public void tearDown() {
        game = null;
        mainFrame = null;
    }

    @Test
    public void testSetMainFrameWhenCalledThenMainFrameFieldIsSet() throws NoSuchFieldException, IllegalAccessException {
        // Act
        game.setMainFrame(mainFrame);

        // Assert
        Field field = game.getClass().getDeclaredField("mainFrame");
        field.setAccessible(true);
        assertEquals(mainFrame, field.get(game), "The mainFrame field should be set to the provided MainFrame object");
    }
}