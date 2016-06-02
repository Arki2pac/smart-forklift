package sample.Genetic;

public class Algorithm {

    // parametry algorytmu
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Rozwiń populację
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Zachowaj najlepszego osobnika
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Skrzyżuj populację
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Przejdź przez wszystkie osobniki populacji i skrzyżuj je
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Zmutuj populację
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Krzyżuj populację
    // Jeżeli wylosowana liczba jest mniejsza od 0.5 weź gen pierwszego osobnika w przeciwnym razie weź gen drugiego
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        // Loop through genes
        for (int i = 0; i < indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    // Zmutuj osobnika
    private static void mutate(Individual indiv) {
        // Przejdź po wszystkich genach osobnika
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Jeżeli wylosowana liczba jest mniejsza od mutation rate losuj gen 0 lub 1
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
                System.out.print("");
                System.out.print(" Mutation!");
            }
        }
    }

    // Wybierz osobniki do skrzyżowania
    private static Individual tournamentSelection(Population pop) {
        // Stwórz populację do konkursu
        Population tournament = new Population(tournamentSize, false);
        // Dla każdego z miejsc w konkursie weź losowego osobnika
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // Zwróć najlepiej przystosowanego osobnika
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}