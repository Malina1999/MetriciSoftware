package implementation;

public class CanvasTest extends AssertJSwingJUnitTestCase {

    private Canvas canvas;

    @Before
    public void setUp() {
        canvas = GuiActionRunner.execute(Canvas::new);
        panel = new JPanelFixture(robot(), canvas);
    }

    @Test
    public void testDisplayHighscoreWhenScoreIsZeroAndWinIsTrueThenNamePanelNotAddedAndBackgroundNotChanged() {
        Color initialBackground = canvas.getBackground();
        GuiActionRunner.execute(() -> canvas.displayHighscore(0, true));
        assertThat(canvas.getComponents()).doesNotContain(canvas.namePanel);
        assertThat(canvas.getBackground()).isEqualTo(initialBackground);
    }

    @Test
    public void testDisplayHighscoreWhenScoreIsZeroAndWinIsFalseThenNamePanelNotAddedAndBackgroundNotChanged() {
        Color initialBackground = canvas.getBackground();
        GuiActionRunner.execute(() -> canvas.displayHighscore(0, false));
        assertThat(canvas.getComponents()).doesNotContain(canvas.namePanel);
        assertThat(canvas.getBackground()).isEqualTo(initialBackground);
    }

    @Test
    public void testDisplayHighscoreWhenScoreIsNonZeroAndWinIsTrueThenNamePanelAddedAndBackgroundChanged() {
        Color initialBackground = canvas.getBackground();
        GuiActionRunner.execute(() -> canvas.displayHighscore(1, true));
        assertThat(canvas.getComponents()).contains(canvas.namePanel);
        assertThat(canvas.getBackground()).isNotEqualTo(initialBackground);
    }

    @Test
    public void testDisplayHighscoreWhenScoreIsNonZeroAndWinIsFalseThenNamePanelAddedAndBackgroundChanged() {
        Color initialBackground = canvas.getBackground();
        GuiActionRunner.execute(() -> canvas.displayHighscore(1, false));
        assertThat(canvas.getComponents()).contains(canvas.namePanel);
        assertThat(canvas.getBackground()).isNotEqualTo(initialBackground);
    }

    @Test
    public void testDisplayHighscoreWhenWinningGameAndReachingTopListThenStateIsCorrect() {
        long score = 100;
        boolean win = true;

        canvas.displayHighscore(score, win);

        verify(resultText).setText("You win!");
        verify(lPane).add(namePanel, JLayeredPane.DRAG_LAYER);
        verify(lPane).setBackground(new Color(0, 250, 209, 255));
    }

    @Test
    public void testDisplayHighscoreWhenLosingGameAndReachingTopListThenStateIsCorrect() {
        long score = 100;
        boolean win = false;

        canvas.displayHighscore(score, win);

        verify(resultText).setText("You lose");
        verify(lPane).add(namePanel, JLayeredPane.DRAG_LAYER);
        verify(lPane).setBackground(new Color(0, 250, 209, 255));
    }

    @Test
    public void testDisplayHighscoreWhenNotReachingTopListThenStateIsCorrect() {
        long score = 0;
        boolean win = true;

        canvas.displayHighscore(score, win);

        verify(resultText).setText("You win!");
        verify(lPane, Mockito.never()).add(namePanel, JLayeredPane.DRAG_LAYER);
        verify(lPane).setBackground(new Color(0, 250, 209, 255));
    }
}