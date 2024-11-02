import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FrequencyGuesser implements WheelOfFortunePlayer {
    Map<Double, Character> characterFrequencies = getCharacterFrequencies();
    TreeSet<Double> frequencies = getFrequencies();

    public static Map<Double, Character> getCharacterFrequencies() {
        Map<Double, Character> characterFrequencies = new HashMap<Double, Character>();
        characterFrequencies.put(0.082, 'a');
        characterFrequencies.put(0.015, 'b');
        characterFrequencies.put(0.028, 'c');
        characterFrequencies.put(0.043, 'd');
        characterFrequencies.put(0.127, 'e');
        characterFrequencies.put(0.022, 'f');
        characterFrequencies.put(0.020, 'g');
        characterFrequencies.put(0.061, 'h');
        characterFrequencies.put(0.070, 'i');
        characterFrequencies.put(0.0015, 'j');
        characterFrequencies.put(0.0077, 'k');
        characterFrequencies.put(0.040, 'l');
        characterFrequencies.put(0.024, 'm');
        characterFrequencies.put(0.067, 'n');
        characterFrequencies.put(0.075, 'o');
        characterFrequencies.put(0.019, 'p');
        characterFrequencies.put(0.00095, 'q');
        characterFrequencies.put(0.060, 'r');
        characterFrequencies.put(0.063, 's');
        characterFrequencies.put(0.091, 't');
        characterFrequencies.put(0.028, 'u');
        characterFrequencies.put(0.0098, 'v');
        characterFrequencies.put(0.024, 'w');
        characterFrequencies.put(0.0015, 'x');
        characterFrequencies.put(0.020, 'y');
        characterFrequencies.put(0.00074, 'z');
        return characterFrequencies;
    }

    public static TreeSet<Double> getFrequencies() {
        TreeSet<Double> frequencies = new TreeSet<Double>();
        frequencies.add(0.082);
        frequencies.add(0.015);
        frequencies.add(0.028);
        frequencies.add(0.043);
        frequencies.add(0.127);
        frequencies.add(0.022);
        frequencies.add(0.020);
        frequencies.add(0.061);
        frequencies.add(0.070);
        frequencies.add(0.0015);
        frequencies.add(0.0077);
        frequencies.add(0.040);
        frequencies.add(0.024);
        frequencies.add(0.067);
        frequencies.add(0.075);
        frequencies.add(0.019);
        frequencies.add(0.00095);
        frequencies.add(0.060);
        frequencies.add(0.063);
        frequencies.add(0.091);
        frequencies.add(0.028);
        frequencies.add(0.0098);
        frequencies.add(0.024);
        frequencies.add(0.0015);
        frequencies.add(0.020);
        frequencies.add(0.00074);
        return frequencies;
    }

    @Override
    public Character nextGuess(WheelOfFortune.GameState gameState) {
        Double maxFrequency = frequencies.first();
        frequencies.remove(maxFrequency);
        Character guess = characterFrequencies.get(maxFrequency);
        characterFrequencies.remove(maxFrequency);
        return guess;
    }

    @Override
    public String playerID() {
        return "";
    }

    @Override
    public void reset() {
        characterFrequencies = getCharacterFrequencies();
        frequencies = getFrequencies();

    }
}
