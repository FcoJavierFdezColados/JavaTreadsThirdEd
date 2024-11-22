package chapter2;

public class CharacterEvent {
    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource characterSource, int character){
        source = characterSource;
        this.character = character;
    }
}
