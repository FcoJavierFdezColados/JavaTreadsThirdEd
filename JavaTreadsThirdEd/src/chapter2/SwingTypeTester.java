package chapter2;

import javax.swing.*;

public class SwingTypeTester extends JFrame implements CharacterSource {

    protected RandomCharacterGenerator producer;
    private CharacterDisplayCanvas displayCanvas;
    private CharacterDisplayCanvas feedbackCanvas;
    private JButton quitButton;
    private JButton startButton;
    private CharacterEventHandler handler;

    public SwingTypeTester() {
        initComponets();
    }

    private void initComponets() {
    }

    @Override
    public void addCharacterListener(CharacterListener characterListener) {

    }

    @Override
    public void removeCharacterListener(CharacterListener characterListener) {

    }

    @Override
    public void nextCharacter() {

    }
}
