package controller;

public class SettingsPanelTest {

    private SettingsPanel settingsPanel;
    private MainFrame mainFrame;

    @BeforeEach
    public void setUp() {
        mainFrame = Mockito.mock(MainFrame.class);
        settingsPanel = new SettingsPanel(mainFrame);
    }

    @Test
    public void testInitComponentsWhenCalledThenComponentsInitialized() {
        // Act
        settingsPanel.initComponents();

        // Assert
        assertNotNull(settingsPanel.scoreLabel);
        assertNotNull(settingsPanel.rowsSpinner);
        assertNotNull(settingsPanel.colorSpinner);
        assertNotNull(settingsPanel.newGameButton);
        assertNotNull(settingsPanel.stopGameButton);
    }

    @Test
    public void testInitComponentsWhenNewGameButtonClickedThenMainFrameActionPerformedCalledWithCorrectActionCommand() {
        // Arrange
        settingsPanel.initComponents();

        // Act
        settingsPanel.newGameButton.doClick();

        // Assert
        Mockito.verify(mainFrame, Mockito.times(1)).actionPerformed(Mockito.argThat(e -> e.getActionCommand().equals("NEW GAME")));
    }

    @Test
    public void testInitComponentsWhenStopGameButtonClickedThenMainFrameActionPerformedCalledWithCorrectActionCommand() {
        // Arrange
        settingsPanel.initComponents();

        // Act
        settingsPanel.stopGameButton.doClick();

        // Assert
        Mockito.verify(mainFrame, Mockito.times(1)).actionPerformed(Mockito.argThat(e -> e.getActionCommand().equals("STOP GAME")));
    }
}