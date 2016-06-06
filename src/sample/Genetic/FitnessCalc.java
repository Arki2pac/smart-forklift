package sample.Genetic;

public class FitnessCalc {

    static byte[] solution = new byte[11];

    // Ustaw rozwiązanie
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    public static byte[] getSolution() {
        return solution;
    }

    // Ustaw rozwiązanie ze stringa zer i jedynek.
    static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        // Loop through each character of our string and save it in our byte
        // array
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    // Dla danego osobnika sprawdź jego przystosowanie w stosunku do rozwiązania
    static int getFitness(Individual individual) {
        int fitness = 0;

        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    // Zwróć max dopasowanie
    static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}