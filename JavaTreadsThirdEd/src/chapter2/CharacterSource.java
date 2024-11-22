package chapter2;

public interface CharacterSource {
    public void addCharacterListener(CharacterListener characterListener);
    public void removeCharacterListener(CharacterListener characterListener);
    public void nextCharacter();
}
