package chapter2;

import javax.swing.*;
import java.awt.*;

public class CharacterDisplayCanvas extends JComponent implements CharacterListener {
    protected FontMetrics fontMetrics;
    protected char[] tmpChar = new char[1];
    protected int fontHeight;

    public CharacterDisplayCanvas() {
        setFont(new Font("Monospaced", Font.BOLD, 18));
        fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(getFont());
        fontHeight = fontMetrics.getHeight();
    }

    public CharacterDisplayCanvas(CharacterSource characterSource) {
        this();
        setCharacterSource(characterSource);
    }

    public void setCharacterSource(CharacterSource characterSource) {
        characterSource.addCharacterListener(this);
    }

    public Dimension preferredSize() {
        return new Dimension(
                fontMetrics.getMaxAscent() + 10,
                fontMetrics.getMaxAdvance() + 10
        );
    }

    public synchronized void paintComponent(Graphics graphics) {
        Dimension dimension = getSize();
        graphics.clearRect(0, 0, dimension.width, dimension.height);
        if(tmpChar[0] == 0) {
            return;
        }
        int charWith = fontMetrics.charWidth((int) tmpChar[0]);
        graphics.drawChars(
                tmpChar,
                1,
                1,
                (dimension.height) / 2,
                fontHeight

        );
    }

    @Override
    public synchronized void newCharacter(CharacterEvent characterEvent) {
        tmpChar[0] = (char) characterEvent.character;
        repaint();
    }
}
