package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import utils.Constants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressFBWarnings("EI_EXPOSE_REP2")
public class SettingsPanel extends JPanel {

    private MainFrame mainFrame;
    private JLabel scoreLabel;
    private JSpinner rowsSpinner;
    private JSpinner colorSpinner;

    /**
     * constructor, initiates the panel and sets the parameter
     * as its mainframe
     *
     * @param m mainframe to be set
     */
    public SettingsPanel(MainFrame m) {
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.darkGray));
        setLayout(new BorderLayout());
        mainFrame = m;
    }

    /**
     * initiates the components of the panel and sets the look
     * and the actionlisteners
     */
    public void initComponents() {
        JPanel lowerPanel;
        scoreLabel = new JLabel("0", SwingConstants.CENTER);
        scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.pink));
        scoreLabel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        scoreLabel.setFont(new Font(scoreLabel.getFont().getName(), Font.BOLD, 34));

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));


        JPanel rowsPanel = new JPanel();
        rowsPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        rowsPanel.setLayout(new BorderLayout());
        SpinnerModel rowsModell = new SpinnerNumberModel(7, 3, 15, 1);
        rowsSpinner = new JSpinner(rowsModell);

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 50));
        colorPanel.setLayout(new BorderLayout());

        SpinnerModel colorModell = new SpinnerNumberModel(4, 2, 8, 1);
        colorSpinner = new JSpinner(colorModell);
        JLabel colorLabel = new JLabel("INITIAL COLORS");
        colorLabel.setFont(new Font(colorLabel.getFont().getName(), Font.CENTER_BASELINE, 14));
        colorLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
        colorPanel.add(colorLabel, BorderLayout.WEST);
        colorPanel.add(colorSpinner, BorderLayout.EAST);
        colorPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JButton newGameButton;
        JPanel buttonPanel = new JPanel();
        newGameButton = new JButton("New Game");
        newGameButton.setActionCommand("NEW GAME");
        newGameButton.addActionListener(mainFrame);

        JButton stopGameButton;
        stopGameButton = new JButton("Stop Game");
        stopGameButton.setActionCommand("STOP GAME");
        stopGameButton.addActionListener(mainFrame);
        buttonPanel.add(newGameButton);
        buttonPanel.add(stopGameButton);

        lowerPanel.add(rowsPanel);
        lowerPanel.add(colorPanel);
        lowerPanel.add(buttonPanel);

        JPanel spaceholder = new JPanel();
        spaceholder.setPreferredSize(new Dimension(Constants.WINDOW_SIZE_X - Constants.FIELD_SIZE_X - 5, 340));
        lowerPanel.add(spaceholder);
        add(scoreLabel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.CENTER);
    }

    /**
     * updates the score in the score counter field
     *
     * @param score the score to be set
     */
    public void updateScore(long score) {
        scoreLabel.setText((Long.toString(score)));
    }

    /**
     * returns the selected number of rows
     *
     * @return the selected number of rows on the spinner
     */
    public int getRow() {
        return (int) rowsSpinner.getValue();
    }

    /**
     * returns the selected number of colors
     *
     * @return the selected number of colors on the spinner
     */
    public int getColor() {
        return (int) colorSpinner.getValue();
    }

}
