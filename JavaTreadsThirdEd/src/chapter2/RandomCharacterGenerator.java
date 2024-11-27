package chapter2;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource{
    static char[] chars;
    static String charArray = "abcdefghijklmnñopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }
    Random random;
    CharacterEventHandler handler;

    public RandomCharacterGenerator() {
        random = new Random();
        handler = new CharacterEventHandler();
    }

    public int getPauseTime() {
        return (int) (Math.max(1000, 5000 * random.nextDouble( )));
    }

    @Override
    public void addCharacterListener(CharacterListener characterListener) {
        handler.addCharacterListener(characterListener);
    }

    @Override
    public void removeCharacterListener(CharacterListener characterListener) {
        handler.removeCharacterListener(characterListener);
    }

    @Override
    public void nextCharacter() {
        handler.fireNewCharacter(this, (int)chars[random.nextInt(chars.length)]);
    }

    public void run() {
        for(;;){
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());

            } catch (InterruptedException ie) {
                return;
            }
        }
    }
}
