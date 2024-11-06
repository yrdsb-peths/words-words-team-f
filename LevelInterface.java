import java.util.ArrayList;



public interface LevelInterface
{
    void loadWordsFromFile(String filename);
    void showWords(ArrayList<String> words);
    void clearWords();
    void startInputPhase();
}