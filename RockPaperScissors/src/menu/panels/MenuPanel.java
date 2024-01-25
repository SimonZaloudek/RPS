package menu.panels;

import menu.Frame;
import menu.buttons.Button;
import menu.buttons.EButtons;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel implements IPanel {

    private final Frame frame;
    private String mapPath;
    public MenuPanel(Frame pFrame, String mapPath) {
        this.frame = pFrame;
        this.mapPath = mapPath;
        if (this.mapPath == null || this.mapPath.isEmpty()) {
            this.mapPath = "assets/gamePanelMain.png";
        }

        this.setupPanel(Color.BLACK, 600, 800);
        this.setupButtons();

        this.frame.add(this);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);

        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    public void setupPanel(Color color, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void setupButtons() {

        Button menuButton = new Button(EButtons.MENU,this, 30, 30, 540, 150, 1);
        this.add(menuButton);

        Button playButton = new Button(EButtons.PLAY,this, 40, 250, 175, 75, "PLAY");
        this.add(playButton);

        Button helpButton = new Button(EButtons.HELP,this, 40, 400, 175, 65, "HELP");
        this.add(helpButton);

        Button optionsButton = new Button(EButtons.OPTIONS,this, 40, 550, 175, 65, "OPTIONS");
        this.add(optionsButton);

        Button exitButton = new Button(EButtons.EXIT,this, 40, 695, 175, 65, "EXIT");
        this.add(exitButton);
    }

    @Override
    public void onButtonClick(EButtons button) {
        switch (button) {
            case PLAY -> {
                this.frame.remove(this);
                this.frame.add(new PreGameMenu(this.frame, this.mapPath));
            }
            case HELP -> {
                this.frame.remove(this);
                this.frame.add(new HelpPanel(this.frame, this.mapPath));
            }
            case OPTIONS -> {
                this.frame.remove(this);
                this.frame.add(new OptionsPanel(this.frame));
            }
            case EXIT -> System.exit(0);
        }
    }
}
