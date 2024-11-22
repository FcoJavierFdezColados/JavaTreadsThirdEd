package chapter2;

import java.util.Vector;

public class CharacterEventHandler {

    private Vector listeners = new Vector<>();

    public void addCharacterListener(CharacterListener characterListener) {
        listeners.add(characterListener);
    }

    public void removeCharacterListener(CharacterListener characterListener) {
        listeners.remove(characterListener);
    }

    public void fireNewCharacter(CharacterSource source, int character) {
        CharacterEvent characterEvent = new CharacterEvent(source, character);
        CharacterListener[] characterListeners = (CharacterListener[])
            listeners.toArray(new CharacterListener[0]);

        for (int i = 0; i < characterListeners.length; i++) {
            characterListeners[i].newCharacter(characterEvent);
        }
    }
}
