package sample.Genetic;

public class Population {

    Individual[] individuals;

    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        // Stwórz populację
        if (initialise) {
            // Stwórz nowe osobniki
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();

                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);

          /*      newIndividual.generateIndividual("110101101011010");
                saveIndividual(0, newIndividual);

                newIndividual = new Individual();
                newIndividual.generateIndividual("101010010100101");
                saveIndividual(1, newIndividual);

                newIndividual = new Individual();
                newIndividual.generateIndividual("110010101100100");
                saveIndividual(2, newIndividual);

                newIndividual = new Individual();
                newIndividual.generateIndividual("100001100010011");
                saveIndividual(3, newIndividual);

                newIndividual = new Individual();
                newIndividual.generateIndividual("001010101100100");
                saveIndividual(4, newIndividual);*/

            }
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Znajdź najlepiej dopasowane osobniki
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}